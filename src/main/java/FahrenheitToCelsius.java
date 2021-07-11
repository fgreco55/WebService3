import java.util.ArrayList;

public class FahrenheitToCelsius implements Command{

    public String doCommand(ArrayList<String> cmd) {
        if (cmd.size() == 1) {
            return "F2C requires an argument (fahrenheit value)";
        }
        double temp = Double.parseDouble(cmd.get(1));
        return Double.toString((temp - 32) * (5./9.));
    }
}
