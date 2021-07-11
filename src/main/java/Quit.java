import java.util.ArrayList;

public class Quit implements Command {
    @Override
    public String doCommand(ArrayList<String> cli) {
        System.out.println("Thanks for using this app!");
        System.exit(0);
        return "";          // Just to satisfy the compiler... should never execute this line after exit().
    }
}
