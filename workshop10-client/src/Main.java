import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Client client = new Client(name);
        Send send;
        Receive receive;
        try {
            Socket socket = new Socket("localhost",4000);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream.writeObject("#" + name);                            // vaghti har client accept shod ye string be format "#" + name be server mide ta server be baghie bege in client ba in name joined shod
            send = new Send(outputStream, client);
            receive = new Receive(inputStream);
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(send);
            executorService.execute(receive);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}