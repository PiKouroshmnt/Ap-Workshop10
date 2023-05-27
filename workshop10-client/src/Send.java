import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Send implements Runnable{
    private ObjectOutputStream outputStream;
    private Client client;

    public Send(ObjectOutputStream outputStream , Client client) {
        this.outputStream = outputStream;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!(input.equalsIgnoreCase("#exit"))) {
            try {
                outputStream.writeObject(client.getClientName() + ": " + input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            input = scanner.nextLine();
        }
        try {
            outputStream.writeObject("$" + client.getClientName());          //vaghti har client bekhad left bede ye string be format "$" + name be server mide ta server be baghie bege ke client ba in name left daad.
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
