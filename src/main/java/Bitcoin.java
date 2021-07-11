import java.util.ArrayList;

public class Bitcoin extends ServiceCommunicator implements Command {
    
    public String XdoCommand(ArrayList<String> cli) {
        setURL("https://api.coindesk.com/v1/bpi/currentprice.json");
        connect();
        String myjson = Utility.showJSON(get());        // Get the JSON string
        return Utility.getValue(myjson, cli.get(1));     // Get the particular value in the JSON string
    }

    public String doCommand(ArrayList<String> cli) {
         setURL("https://api.coindesk.com/v1/bpi/currentprice.json");
         connect();
         String myjson = Utility.showJSON(get());        // Get the JSON string
         return myjson;     // Get the particular value in the JSON string
     }
}
