import java.io.Serializable;
public class sendMail implements Serializable {
    
    public int senderID;    // The ID number of the sender.
    public int recipientID; // The ID number of the recipient.
    public String to;
	public String subject;
	public String message;

    public sendMail(int recipientID,String subject,String message,String to) {
        this.recipientID = recipientID;
        this.to=to;
        this.message = message;
        this.subject = subject;
    }

}