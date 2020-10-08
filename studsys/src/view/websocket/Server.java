package view.websocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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
    File m_getResponse = null;

    public Server(String a_pathToGetResponseFile) throws IOException {
        m_server = new ServerSocket(1717);

        if (a_pathToGetResponseFile != null) {
            m_getResponse = new File(a_pathToGetResponseFile); // hard coded for now
            if (!m_getResponse.exists()) {
                m_getResponse = null;
                System.out.println("Response File not found: " + a_pathToGetResponseFile);
            }
        }
    }

    public Client acceptClient() throws IOException {


        Socket client = m_server.accept();
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();

        try {
            Scanner s = new Scanner(in, "UTF-8");
            String data = s.useDelimiter("\\r\\n\\r\\n").next();
            Matcher get = Pattern.compile("^GET").matcher(data);
            if (get.find()) {
                String wsKeyConst = "Sec-WebSocket-Key:";
                Matcher match = Pattern.compile(wsKeyConst + " (.*)").matcher(data);
                if (match.find()) {

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

                    // now we can create the client
                    Client ret = new Client(client, in, out);

                    return ret;
                } else {
                    handlePlainHTTP(in, out);
                    return null;
                }
            }
        } catch (IOException e) {
            out.close();
            in.close();
            throw e;
        }

        // not a get request
        return null;
    }

    private void handlePlainHTTP(InputStream in, OutputStream out) {
        Runnable r = new Runnable() {
            @Override
            public void run() {

                try {
                    if (m_getResponse != null) {
                        // not a websocket request lets just reply with the html for the client
                        byte[] header = ("HTTP/1.1 200 OK\r\n"
                                + "Content-Type: text/html\r\n"
                                + "Connection: Closed\r\n"
                                + "Content.Length: " + m_getResponse.length() + "\r\n"
                                + "\r\n").getBytes("UTF-8");

                        out.write(header);
                        Files.copy(m_getResponse.toPath(), out);
                        out.flush();
                        in.close();
                        out.close();

                    } else {
                        // no default response
                        byte[] response = "No Default http GET Response File Found".getBytes("UTF-8");
                        byte[] header = ("HTTP/1.1 404 OK\r\n"
                                + "Content-Type: text/html\r\n"
                                + "Connection: Closed\r\n"
                                + "Content.Length: " + response.length + "\r\n"
                                + "\r\n").getBytes("UTF-8");

                        out.write(header);
                        out.write(response);
                        out.flush();
                        in.close();
                        out.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread c = new Thread(r);
        c.start();
    }
}
