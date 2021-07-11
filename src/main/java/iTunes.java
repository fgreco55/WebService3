import java.util.ArrayList;

public class iTunes extends ServiceCommunicator implements Command {
    /*
         iTunes - contacts iTunes server and returns artist information.
    */
    public iTunes (String artist) {
        super("https://itunes.apple.com/search?term=" + artist + "\\&limit=1");
    }

    public iTunes() {
        super();
    }
    /*
        Main method - just tests this class in isolation.  Normally you would have another class call iTunesTool
    */
        public static void main(String[] argv) {
            iTunes it = new iTunes();

            ArrayList<String> test1 = new ArrayList<>();
            test1.add("beyonce");
            System.out.println(it.doCommand(test1));

            it = new iTunes();          // Create a new instance... let the garbage collector reclaim the old one

            test1.clear();
            test1.add("billie-eilish");
            System.out.println(it.doCommand(test1));
        }

    @Override
    public String doCommand(ArrayList<String> cmd) {

        if (cmd.size() == 1)                    // No musical artist requested.
            return "music 'artist'";

        setURL("https://itunes.apple.com/search?term=" + cmd.get(1) + "\\&limit=1");
        connect();
        return Utility.showJSON(get());         // return pretty-printed JSON
    }
}
