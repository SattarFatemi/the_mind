package client;

import request.SelectName;
import request.ShowLobby;
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
    private boolean host = false;

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
        Scanner scanner = new Scanner(System.in);
        String input = null;
        //TODO
        selectName();
        selectTable();

        if (host) {
            System.out.println("You're the host.");
            System.out.println("Type 'start' to start the game!");
            input = scanner.nextLine();
            while (!input.equals("start")) {
                System.out.println("Type 'start' to start the game!");
                scanner.nextLine();
            }
        }

        try {
            while (true) {
                input = scanner.nextLine();

                if (input.equals("Ninja Card")) {
                    //TODO a new instance of ninja card proposal
                }
                else {
                    try {
                        int card = Integer.parseInt(input);
                        //TODO a new instance of drop card

                    } catch (NumberFormatException exception) {
                        System.out.println("Your input was invalid!");
                    }
                }
            }
        } catch(Exception e) {
            System.out.println("Finished?");
        }
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
            // TODO is host or not?
        }
    }

    private <T> void sendRequest(T object) {
        Gson gson = new Gson();
        JsonArray array = new JsonArray();
        array.add(object.getClass().toString());
        array.add(gson.toJson(object));

        try {
            dos.writeUTF(gson.toJson(array));
            dos.flush();
        } catch (IOException e) {
            System.out.println("------ error: Couldn't writeUTF/flush dos!");
        }
    }

    public DataInputStream getDis() {
        return this.dis;
    }
}
