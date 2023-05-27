import java.io.IOException;
import java.io.ObjectInputStream;


public class Receive implements Runnable{
    private ObjectInputStream inputStream;
    private boolean state;

    public Receive(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
        state = true;
    }

    public void endProgram() {
        state = false;
    }

    @Override
    public void run() {
        while (state) {
            try {
                String input = (String) inputStream.readObject();
                if(input.startsWith("$")) {    // vaghti client left daad hamoon string ke be server daade mishe ro be clienty ke left daade  bargardoon ta be exception nakhorim
                    break;
                }
                System.out.println(input);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}
