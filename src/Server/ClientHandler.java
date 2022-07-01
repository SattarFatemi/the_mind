package Server;

import com.google.gson.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class ClientHandler implements Runnable {
    final Socket socket;
    final int id;

    public ClientHandler(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            while (true) {
                System.out.println("thread is running...");
                JsonParser parser = new JsonParser();
                String input = dis.readUTF();
                System.out.println("input: " + input);
                Object object = parser.parse(input);
                JsonArray jsonArray = (JsonArray) object;

                System.out.println(input);

                for (int i = 0; i < jsonArray.size(); i++) {
                    JsonObject jsonObject = (JsonObject) jsonArray.get(i);
                    Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
                    for (Map.Entry<String, JsonElement> entry : entries) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                }

                /*Request request = new Gson().fromJson(dis.readUTF(), Request.class);
                if (request.type.equals(Type.MOVE)) {
                    Server.getInstance().addToHistory(request.output);
                }
                Response response;
                ArrayList<String> arr = update();
                if (arr.size() > 0)
                    response = new Response(true, arr);
                else
                    response = new Response(false, null);
                String json = new Gson().toJson(response);
                dos.writeUTF(json);
                dos.flush();*/
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("========== client handler run func");
        }
    }
}
