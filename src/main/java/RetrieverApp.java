import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
    RetrieverApp - simple app to retrieve web information based on user input from the console
 */
public class RetrieverApp {
    HashMap<String, Command> serviceList = new HashMap<>();         // All the possible commands for this app

    public static void main(String[] args) {
        Command mc;
        String results;                     // String that returns from the website
        ArrayList<String> command;          // "music", "zipcode", "television"

        RetrieverApp rp = new RetrieverApp();       // Create an instance of this class
        rp.initializeList();                        // Populate the Hashmap with Command objects

        while (true) {
            System.out.print("Cmd> ");
            command = rp.getUserInput();                            // Get an ArrayList of the user's command line tokens

            if (command.size() == 0)                                // No input from the user... just empty <CR>
                continue;

            String cmdName = command.get(0);                        // The 0th token is the command
            if (rp.serviceList.containsKey(cmdName)) {              // If you find a Command in the Hashmap with that key...
                mc = rp.serviceList.get(cmdName.toLowerCase());     // Get the object that implements Command

                results = mc.doCommand(command);                    // Run it!

            } else {
                System.out.println("I'm sorry.  [" + cmdName + "] is an invalid service.");
                continue;
            }
            
            System.out.println(results);
        }
    }

    /*
      initializeList() - Add all the commands and an object that will do the work.
                         With a redesigned ServiceCommunicator, it makes it easier!
     */
    public void initializeList() {

        serviceList.put("zipcode", new Zip());
        serviceList.put("music", new iTunes());
        serviceList.put("television", new Tv());
        serviceList.put("freemem", new FreeMem());
        serviceList.put("f2c", new FahrenheitToCelsius());
        serviceList.put("c2f", new CelsiusToFahrenheit());
        serviceList.put("bitcoin", new Bitcoin());
        serviceList.put("quit", new Quit());
        serviceList.put("help", new Help(serviceList));     // see Help.java to see why I'm passing a reference to the Hashmap
    }

    /*
          getUserInput() - get the input from the user for each command as an ArrayList.
     */
    public ArrayList<String> getUserInput() {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> commandline = new ArrayList<>();

        if (scan.hasNextLine()) {
            String cmd = scan.nextLine();
            if (!cmd.isEmpty()) {
                Scanner tokens = new Scanner(cmd);
                while (tokens.hasNext()) {
                    commandline.add(tokens.next());
                }
            }
        }
        return commandline;
    }
}
