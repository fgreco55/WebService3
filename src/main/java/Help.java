import java.util.ArrayList;
import java.util.HashMap;

public class Help implements Command{
    HashMap<String, Command> mylist;        // Just a reference to the Hashmap in the main application

    /*
       I need the HashMap if I want to show all the allowable commands (ie, hashmap keys), so I need a reference
        to that HashMap in this object.
     */
    Help(HashMap<String, Command> serviceList) {
        mylist = serviceList;           // a reference to the existing hashmap in the application object.
    }

    /*
      doCommand() - Here I hard-coded the help, but notice the chance of error if I add another command
                    but forget to update this string.  Its better to show the commands by going through
                    the HashMap showing the keys.  But we have not covered "keySet()", but I wanted to
                    show you how to do that.
     */
    @Override
    public String doCommand(ArrayList<String> cmd) {
        /*String result = "";

        for (String name : mylist.keySet()) {
           result += name + ", ";
        }
        return result;*/
       return "zipcode, music, television, freemem, help, f2c, c2f, bitcoin, quit";
    }
}
