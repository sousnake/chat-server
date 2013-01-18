import java.io.Serializable;
import java.util.TreeMap;
public class ClientConnectedMessage implements Serializable {
    
    public int newClientID;  
    public TreeMap<Integer,String> nameMap;  
    
    public ClientConnectedMessage(int newClientID, TreeMap<Integer,String> nameMap) {
        this.newClientID = newClientID;
        this.nameMap = nameMap;
    }

}
