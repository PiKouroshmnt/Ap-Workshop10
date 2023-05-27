import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Reciever implements Runnable{
    private User user;
    private Socket socket;
    public Reciever(User user, Socket socket){
        this.user = user;
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            Scanner scanner = new Scanner(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
