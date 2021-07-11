import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
/*
 Simplistic utility class to connect to a web server and retrieve data.
 This version is a little better than the original since it separates the methods more logically.
 Note how how the functionality is more "granular".  I want you to see why get() did "too much" and how
 you should create specific methods.
 -fdg
 */
public class ServiceCommunicator {
    private HttpURLConnection conn;
    private String url;

/*
 Constructor - supply the target URL and try to make the connection
 */
    public ServiceCommunicator(String url) {
        super();
        this.url = url;
    }

    public ServiceCommunicator() {
        super();
    }

    /*
     setURL() - initialize the target URL
     */
    public void setURL(String serviceURL) {
       this.url = serviceURL;
    }

    /*
     connect() - make the connection to the website
     */
    public void connect() {
        try {
            URL url = new URL(this.url);
            URLConnection urlConnection = url.openConnection();
            conn = (HttpURLConnection) urlConnection;
        } catch (Exception ex) {
            System.err.println("**Error in constructor - Cannot create the URL or make the connection.");
            System.exit(1);           // Not the best to terminate if there's an error.  This would not be viable in a production application
                                            //   It would better to throw an exception and have the caller handle this situation.
        }
    }

    /*
    get() - read the reply from the webserver specified in the constructor.
          returns a string that captured the output from that service.
    */
    public String get() {
         String urlString = "";
         String current;

         try {
             BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
             while((current = in.readLine()) != null) {
                 urlString += current;
             }
         } catch (IOException iox) {
             System.err.println("**Error in get().  Cannot read from URL. [" + iox.getMessage() + "]");
             return (String)null;
         }
         return urlString;
      }

/*
 main method used just to test this class in isolation.  You will learn more about testing in another course.
 */
      public static void main(String[] argv) {
        System.out.println(new ServiceCommunicator("http://api.zippopotam.us/us/" + "10011").get());
        System.out.println(new ServiceCommunicator("https://itunes.apple.com/search?term=" + "bbking" + "\\&limit=1").get());
        System.err.println("==================================");
        System.out.println(new ServiceCommunicator("http://www.google.com").get());    // Note this is not a Web API call per se.  It just makes a request for the Google home page HTML and JS
      }
}

