import java.io.Serializable;
import java.util.TreeMap;
public class ClientDisconnectedMessage implements Serializable {
    
    public int departingClientID;  
    public String departingClientName;  
    public TreeMap<Integer,String> nameMap;                                               
    public ClientDisconnectedMessage(int departingClientID,String departingClientName, TreeMap<Integer,String> nameMap) {
        this.departingClientID = departingClientID;
        this.departingClientName = departingClientName;
        this.nameMap = nameMap;
    }
    

}
