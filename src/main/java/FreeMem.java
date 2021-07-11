import java.util.ArrayList;

public class FreeMem implements Command{
    @Override
    public String doCommand(ArrayList<String> cmd) {
        Runtime rt = Runtime.getRuntime();          // JVM provides *one* Runtime object

        return String.valueOf(rt.freeMemory());     // amount left in the JVM for your pgm
    }
}
