import java.io.Serializable;

public class sendFile implements Serializable {
    
    public int senderID;    // The ID number of the sender.
    public int recipientID; // The ID number of the recipient.
    byte[] mybytearray;

    public sendFile(int recipientID, byte[] myarray) {
        this.recipientID = recipientID;
        this.mybytearray = myarray;
    }

}