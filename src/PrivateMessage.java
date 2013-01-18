import java.io.Serializable;
public class PrivateMessage implements Serializable {
    
    public int senderID;    
    public int recipientID; 
    public String message;  
    public PrivateMessage(int recipientID, String message) {
        this.recipientID = recipientID;
        this.message = message;
    }

}