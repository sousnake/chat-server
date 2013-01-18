import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
public class NewChatRoomHub extends Hub {
    private TreeMap<Integer,String> nameMap = new TreeMap<Integer,String>();
    public NewChatRoomHub(int port) throws IOException {
        super(port);
    }
    protected void extraHandshake(int playerID,ObjectInputStream in, ObjectOutputStream out) throws IOException {
        try {
            String name = (String)in.readObject();
            if (name == null)
                name = "noname";
            if (name.length() > 15)
                name = name.substring(0,15).trim();
            if (name.equals(""))
                name = "noname";
            synchronized(nameMap) {
                if (nameMap.containsValue(name)) {
                    String approvedName = name;
                    int num = 2;
                    while (nameMap.containsValue(approvedName)) {
                        approvedName = name + "#" + num;
                        num++;
                    }
                    name = approvedName;
                }
            }
            out.writeObject(name);
            nameMap.put(playerID,name);
        }
        catch (Exception e) {
            throw new IOException("Error while setting up connection: " + e);
        }
    }
    protected void messageReceived(int playerID, Object message) {
        if (message instanceof PrivateMessage) {
            PrivateMessage pm = (PrivateMessage)message;
            pm.senderID = playerID;
            sendToOne(pm.recipientID, pm);
           String str= pm.toString();
            try {
                BufferedWriter bw=new BufferedWriter(new FileWriter("first.txt"));
                bw.write(str);
            } catch (IOException ex) {
               // Logger.getLogger(NewChatRoomHub.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       else if(message instanceof sendFile){
		sendFile sf = (sendFile)message;
		sf.senderID = playerID;
		sendToOne(sf.recipientID,sf);
		}
       else if (message instanceof sendMail){
		sendMail sm = (sendMail)message;
		sm.senderID = playerID;
		sendToOne(sm.recipientID,sm);
		}
        else
            super.messageReceived(playerID, message);
    }

    protected void playerConnected(int playerID) {
        resetOutput(); // Reset the output stream before resending nameMap.
        sendToAll(new ClientConnectedMessage(playerID,nameMap));
    }

    protected void playerDisconnected(int playerID) {
        String name = nameMap.get(playerID); // Get the departing player's name.
        nameMap.remove(playerID);  // Remove the player from nameMap.
        resetOutput(); // Reset the output stream before resending nameMap.
        sendToAll(new ClientDisconnectedMessage(playerID, name, nameMap));
    }
    
}