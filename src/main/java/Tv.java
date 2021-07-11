import java.util.ArrayList;

public class Tv extends ServiceCommunicator implements Command {
    /*
         Tv - contacts TVMaze server and returns tv show information.
    */
    public Tv(String showname) {
        super("http://api.tvmaze.com/singlesearch/shows?q=" + showname);
    }

    public Tv() {
        super();
    }

    /*
        Main method - just tests this class in isolation.  Normally you would have another class call iTunesTool
    */
    public static void main(String[] argv) {
        Tv t = new Tv();

        ArrayList<String> test1 = new ArrayList<>();
        test1.add("star trek");
        System.out.println(t.doCommand(test1));

        Tv tt = new Tv();
        test1.clear();
        test1.add("chappell");
        System.out.println(tt.doCommand(test1));
    }

    /*
      doCommand() - adds the ability to request some attributes from the JSON.
                       Getting *all* the attributes from the JSON would take more work since
                       there are nested JSON objects and JSON arrays.  An exercise left to the reader... :) -frank
     */
    @Override
    public String doCommand(ArrayList<String> cmdline) {
        String attr;                    // specific attribute of that show
        String results;                 // Returning JSON from the site
        int numOfArgs = cmdline.size(); // number of arguments (just avoiding calling size() multiple times)

        if (numOfArgs == 1)             // No television show requested.
            return "television 'tv-show'";

        setURL("http://api.tvmaze.com/singlesearch/shows?q=" + cmdline.get(1));
        connect();

        results = Utility.showJSON(get());      // Get the results using super.get() and save it.

        if (numOfArgs == 2)
            return results;                     // Show pretty-printed full JSON and we're done

        else if (numOfArgs == 3) {              // Show specific JSON name
            attr = cmdline.get(2);
            switch (attr) {
                case "premier":
                    return Utility.getValue(results, "premiered");
                case "runtime":
                    return Utility.getValue(results, "runtime");
                default:
                    return "**Error.  Valid attributes are [premier|runtime]";
            }
        } else {
            return "**Error.  Invalid number of arguments.  usage:  television show [premier|runtime]";
        }
    }
}

