package view.websocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    ArrayList<Client> m_clients = new ArrayList<>();
    ServerSocket m_server;

    public Server() throws IOException {
        m_server = new ServerSocket(1717);
    }

    public Client acceptClient() throws IOException {


        Socket client = m_server.accept();

        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();
        Scanner s = new Scanner(in, "UTF-8");

        String data = s.useDelimiter("\\r\\n\\r\\n").next();
        Matcher get = Pattern.compile("^GET").matcher(data);
        if (get.find()) {
            String wsKeyConst = "Sec-WebSocket-Key:";
            Matcher match = Pattern.compile(wsKeyConst + " (.*)").matcher(data);
            match.find();
            String wsKey = match.group(1);
            System.out.println("Sec-Websocket-Key: " + wsKey);
            byte[] response = new byte[0];
            try {
                response = ("HTTP/1.1 101 Switching Protocols\r\n"
                        + "Connection: Upgrade\r\n"
                        + "Upgrade: websocket\r\n"
                        + "Sec-WebSocket-Accept: "
                        + Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-1").digest((wsKey + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes("UTF-8")))
                        + "\r\n\r\n").getBytes("UTF-8");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            out.write(response, 0, response.length);
        }

        // now we can create the client
        Client ret = new Client(client, in, out);

        return ret;
    }
}
