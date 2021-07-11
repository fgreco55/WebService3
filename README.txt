This solution uses an application (RetrieverApp) to get simple commands (Zip, Music and Television) to call
the respective classes.

Note it simplifies the main loop by moving most of the code into methods of the class.   It still isn't totally effective
since the commands (eg, "zipcode") are located in multiple places.  So you have to remember to change things in multiple
places.  Something for you to think about.

Also notice the Utility.java class.  This class uses an external library from json.org to create JSON java object
from Strings so we can use Java methods to inspect it.  I made the methods static so you don't have to create any
object instance to use them.  If you look at RetrieverApp, you'll see one of the Utility methods in action.

Frank