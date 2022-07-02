package client;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private final Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private final String authToken;

    public Client(Socket socket) {
        String tmpAuthToken = "";
        this.socket = socket;
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            tmpAuthToken = dis.readUTF();

        } catch (IOException exception) {
            System.out.println("------ error: dis|dos couldn't read|initialize!");
            System.out.println("Is socket connected? " + socket.isConnected());
        }
        this.authToken = tmpAuthToken;
    }

    protected void init() {
        //TODO
    }

    private <T> void sendRequest(T object) {
        Gson gson = new Gson();
        JsonArray array = new JsonArray();
        array.add(gson.toJson(object.getClass().toString()));
        array.add(gson.toJson(object));

        try {
            dos.writeUTF(gson.toJson(array));
            dos.flush();
        } catch (IOException e) {
            System.out.println("------ error: Couldn't writeUTF/flush dos!");
        }
    }
}
