import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    private int port;
    private ArrayList<User> users = new ArrayList<>();
    public Server(int port){
        this.port = port;
    }
    public void runServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is Running on Port: 4000 ...");
            acceptUser(serverSocket);
        }
        catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

    }
    private void acceptUser(ServerSocket serverSocket){
        while (true){
            try{
                Socket socket = serverSocket.accept();
                Scanner scanner = new Scanner(socket.getInputStream());
                String username = (String)scanner.next();
                if (username.startsWith("#")){
                    User user = new User(username, socket);
                    Reciever reciever = new Reciever(user, socket);
                    scanner.close();
                    System.out.println("New User: " + user.getUsername() +" joined");
                    users.add(user);
                    user.getSocket().getOutputStream().write(Integer.parseInt("Welcome to server!"));
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
