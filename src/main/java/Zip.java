import java.util.ArrayList;

public class Zip extends ServiceCommunicator implements Command{
    /*
         Zip - contacts Zipcode server and returns zipcode information.
    */
    public Zip (String zipcode) {
        super("http://api.zippopotam.us/us/" + zipcode);
    }

    public Zip() {
        super();
    }

    /*
        Main method - just tests this class in isolation.  Normally you would have another class call iTunesTool
    */
        public static void main(String[] argv) {

            Zip zippy = new Zip();
            zippy.setURL("http://api.zippopotam.us/us/" + "07032");
            zippy.connect();
            System.out.println(zippy.get());
        }

    public String doCommand(ArrayList<String> cli) {
        if (cli.size() == 1)                    // No zipcode requested.
            return "zipcode 'the-zip-code'";

        setURL("http://api.zippopotam.us/us/" + cli.get(1));
        connect();
        return Utility.showJSON(get());
    }
}
