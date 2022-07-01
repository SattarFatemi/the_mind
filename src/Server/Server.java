package Server;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Server server;
    public ServerSocket serverSocket;
    public static int lastID = 0;

    public static Server getInstance() {
        if (server == null) server = new Server();
        return server;
    }

    private Server() {
        try {
            this.serverSocket = new ServerSocket(8008);
        } catch (IOException e) {
            System.out.println("Server cant find the port.");
            e.printStackTrace();
        }
    }

    public void init() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("socket accepted");
                ClientHandler clientHandler = new ClientHandler(socket, ++lastID);
                new Thread(clientHandler).start();

            } catch (IOException e) {
                System.out.println("===== init func of Server");
            }
        }
    }
}
