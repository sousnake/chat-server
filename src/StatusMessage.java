import java.io.Serializable;
final class StatusMessage implements Serializable {

   public final int playerID;
   public final boolean connecting;
   public final int[] players;
   
   public StatusMessage(int playerID, boolean connecting, int[] players) {
      this.playerID = playerID;
      this.connecting = connecting;
      this.players = players;
   }
   
}

