package Server;

import com.google.gson.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    final Socket socket;
    final int id;
    private DataInputStream dis;
    private DataOutputStream dos;

    public ClientHandler(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                while (true) {
                    /***
                     * we can distinguish type of the request using following code:
                     */

                    //String input = dis.readUTF();
                    String input = "[{'name':'sattar'}, {'age':'19'}]";
                    System.out.println("input: " + input);

                    Gson g = new Gson();
                    JsonArray array = g.fromJson(input, JsonArray.class);

                    JsonObject jsonObject = (JsonObject) array.get(0);

                    System.out.println(jsonObject.get("name"));
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("========== client handler run func");
        }
    }

    private <T> void sendResponse(T response) {
        Gson gson = new Gson();
        JsonArray array = new JsonArray();
        array.add(gson.toJson(response.getClass().toString()));
        array.add(gson.toJson(response));

        try {
            dos.writeUTF(gson.toJson(array));
            dos.flush();
        } catch (IOException e) {
            System.out.println("------ error: Couldn't writeUTF/flush dos!");
        }
    }
}
