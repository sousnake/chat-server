import java.io.Serializable;
final class DisconnectMessage implements Serializable {
   final public String message;
   public DisconnectMessage(String message) {
      this.message = message;
   }
}
