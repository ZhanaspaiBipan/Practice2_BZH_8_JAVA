package practice2_5sem;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class myServer {

    public static void start() throws IOException {
        ServerSocket server = null;
        Socket client = null;
        final int port = 9737;

        BufferedReader in = null;
        PrintWriter out = null;

        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.exit(0);
        }

        try {
            while (true) {
                try {
                    client = server.accept();
                } catch (IOException e) {
                    System.exit(0);
                }
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);

                String messageFromClient;

                String st = null;
                int a = 0, b = 0, x = 0;
                //менять
                while ((messageFromClient = in.readLine()) != null) {
                    a = Integer.parseInt(messageFromClient);
                    break;
                }

                while ((messageFromClient = in.readLine()) != null) {
                    b = Integer.parseInt(messageFromClient);
                    break;
                }
                while ((messageFromClient = in.readLine()) != null) {
                    x = Integer.parseInt(messageFromClient);
                    break;
                }
                while ((messageFromClient = in.readLine()) != null) {
                    st = messageFromClient;
                    break;
                }
                double y = 0;

                if (x >= 6) {
                    y = 4 *( Math.pow(a,2) + 2*x + Math.pow(b, 2))/(a*b);
                } else {
                    y = Math.pow(x,3)* Math.pow(a-b,2);
                }
                out.println("Итог уравнения: " + y);

                out.close();
                in.close();
                client.close();

                if (st.equalsIgnoreCase("stop")) {
                    break;
                }

            }
        } finally {
            server.close();
        }

    }
}
