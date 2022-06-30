package Client;

import Request.SelectName;
import Request.ShowLobby;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private final String authToken;
    private String name;

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
        selectName();
        selectTable();
    }

    private void selectName() {
        Scanner scanner = new Scanner(System.in);
        String name = null;

        boolean flag = true;
        while (flag) {
            System.out.println("Enter your name: ");
            name = scanner.nextLine();
            sendRequest(selectNameRequest(name));

            /*TODO
                dis.readUTF
                handle receive response
                if ok -> flag = false;
             */
        }
        this.name = name;
    }

    private SelectName selectNameRequest(String name) {
        return new SelectName(authToken, name);
    }

    private void selectTable() {
        Scanner scanner = new Scanner(System.in);
        String input = null;

        boolean flag = false;
        while (flag) {
            sendRequest(new ShowLobby(authToken));
            /*TODO
                dis.readUTF
                handle (Lobby) response
             */

            // Todo join/new Table and what comes after
        }
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
