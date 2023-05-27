
public class Main {
    public static void main(String[] args) {
        int port = 4000;
        Server server = new Server(port);
        server.runServer();
    }
}