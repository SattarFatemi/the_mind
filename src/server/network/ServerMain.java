package server.network;


public class ServerMain {
    public static void main(String[] args) {
        Server server = Server.getInstance();
        server.init();
    }
}
