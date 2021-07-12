This solution uses an application (RetrieverApp) to get simple commands (Zip, Music and Television) to call
the respective classes.

This version also changes the rules of the project (but in a good way).  ServiceCommunicator is more "granular" and has 
split up its functionality with more methods in a more logical and fine-grained manner.

Notice the use of a Hashmap to store objects that implement the Command interface.  Interfaces are essentially special classes
that effectively have just APIs, that is, just a method call (or a few method calls) but no implementation of those methods.
Classes that *implement* that interface must implement those methods.  Think of it like a contract.  This allows us
to use a reference (of that interface type) to refer to any object *that implements that interface*.  This is a powerful
feature.  Take a look at all the classes I added that implement the Command interface.  Since they all implement Command,
I was able to store ALL of them in the same Hashmap.  Pretty cool.

Also notice the Utility.java class.  This class uses an external library from json.org to create JSON java object
from Strings so we can use Java methods to inspect it.  I made the methods static so you don't have to create any
object instance to use them.  If you look at RetrieverApp, you'll see one of the Utility methods in action.  I also
added some other methods to retrieve a specific JSON value given its key.

Frank
