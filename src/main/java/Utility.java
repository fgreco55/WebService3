import org.json.JSONObject;

/*
   Utility - collection of utility methods for JSON-related purposes
 */

public class Utility {

    /*
      getJSON(String, int) - convert a String to a JSON object and pretty-print it with a certain indentation
     */
    public static String showJSON(String myjson, int indentation) {
        JSONObject jsonObj = new JSONObject(myjson);    // Creates a JSONObject so we can parse it
        return jsonObj.toString(indentation);
    }

    /*
       getJSON - Just a convenience method that defaults to 4 space indentation
     */
    public static String showJSON(String myjson) {
        return showJSON(myjson, 4);         // Call the above method with 4 spaces for indentation
    }

    /*
       getValue(JSONObject, String) - get a specific value for a JSON key
     */
    public static String getValue(JSONObject myjson, String key) {
        return myjson.get(key).toString();                // JSONObject's get() doesn't return a String, so had to use toString()
    }

    /*
      getValue(String, String) - given a JSON string, convert it to a JSONObject and use the key to retrieve the value
     */
    public static String getValue(String jstring, String key) {
        JSONObject jsonObj = new JSONObject(jstring);      // Creates a JSONObject so we can parse it
        return getValue(jsonObj, key);                     // Call the other overloaded method since we wrote it already!
    }

}

