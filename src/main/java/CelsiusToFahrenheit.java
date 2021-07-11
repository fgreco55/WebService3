import java.util.ArrayList;

public class CelsiusToFahrenheit implements Command {
    public String doCommand(ArrayList<String> cmd) {
            if (cmd.size() == 1) {
                return "C2F requires an argument (celsius value)";
            }
            double temp = Double.parseDouble(cmd.get(1));
            return Double.toString(temp * (9./5.) + 32);
        }
}
