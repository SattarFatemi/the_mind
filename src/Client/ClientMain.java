package Client;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8008);
        Client client = new Client(socket);
    }
}
