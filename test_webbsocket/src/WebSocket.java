// this is based on: https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API/Writing_a_WebSocket_server_in_Java

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebSocket {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        ServerSocket server = new ServerSocket(1717);
        try {
            System.out.println("Server has started on 127.0.0.1:1717.\r\nWaiting for a connection...");
            Socket client = server.accept();
            System.out.println("A client connected.");

            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();
            Scanner s = new Scanner(in, "UTF-8");

            try {
                String data = s.useDelimiter("\\r\\n\\r\\n").next();
                Matcher get = Pattern.compile("^GET").matcher(data);
                if (get.find()) {
                    String wsKeyConst = "Sec-WebSocket-Key:";
                    Matcher match = Pattern.compile(wsKeyConst + " (.*)").matcher(data);
                    match.find();
                    String wsKey = match.group(1);
                    System.out.println("Sec-Websocket-Key: " + wsKey);
                    byte[] response = ("HTTP/1.1 101 Switching Protocols\r\n"
                            + "Connection: Upgrade\r\n"
                            + "Upgrade: websocket\r\n"
                            + "Sec-WebSocket-Accept: "
                            + Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-1").digest((wsKey + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes("UTF-8")))
                            + "\r\n\r\n").getBytes("UTF-8");
                    out.write(response, 0, response.length);
                }

                DataInputStream inStream = new DataInputStream(in);
                DataOutputStream outStream = new DataOutputStream(out);



                while (client.isConnected()) {
                    if (inStream.available() > 0) {
                        Frame inF = new Frame(inStream);
                        System.out.println("data:" +  new String(inF.getData(), StandardCharsets.UTF_8));

                        Frame outF = new Frame("Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel lectus. Donec odio urna, tempus molestie, p");
                        outF.send(outStream);

                        outF = new Frame("Nam quis nulla. Integer malesuada. In in enim a arcu imperdiet malesuada. Sed vel lectus. Donec odio urna, tempus molestie, po");
                        outF.send(outStream);

                        outF = new Frame(BigStrings.sMaxUShort);
                        outF.send(outStream);

                        outF = new Frame(BigStrings.sMaxUShort, "HUUGE!");
                        outF.send(outStream);

                        //outF = new Frame(BigStrings.sMaxUShortPlusOne, "1");
                        //outF.send(outStream);
                    } else {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            } finally {
                s.close();
            }
        } finally {
            server.close();
        }
    }
}
