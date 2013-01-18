import java.io.IOException;
public class NewChatRoomServer {

    private final static int PORT = 3783;
    
    public static void main(String[] args) {
        try {
            new NewChatRoomHub(PORT);
        }
        catch (IOException e) {
            System.out.println("Can't create listening socket.  Shutting down.");
        }
    }
    
}


