import java.io.Serializable;
public class ForwardedMessage implements Serializable {
   
   public final Object message;  // Original message from a client.
   public final int senderID;    // The ID of the client who sent that message.
   public ForwardedMessage(int senderID, Object message) {
      this.senderID = senderID;
      this.message = message;
   }

}
