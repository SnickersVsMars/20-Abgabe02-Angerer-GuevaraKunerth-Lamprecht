# Generics
Generics are used to pass a parameter of any type to methods, class and 
interface. (int, String, class types)

The diamond operator <> is used to specify the parameter type. 
Usually a capital Letter - T in most cases - is used as a type placeholder. 
When using the interface, class or method the desired type needs to be specified
in the diamond operator (e.g. &lt;String&gt; to use String type parameters).

A simple generic class could look like this:

````java
public class GenericTest<T>
{
    // An object of type T is declared
    T obj;
    Test(T obj) {  this.obj = obj;  }  // constructor
    public T getObject()  { return this.obj; }  // returns the obj
}

public class Main
{
    public static void main (String[] args)
    {
        //Instance of String type
        GenericTest<String> iObj = new GenericTest<String>("test");
        System.out.println(iObj.getObject());

        //Instance of Integer type
        Test<Integer> sObj = new GenericTest<Integer>(100);
        System.out.println(sObj.getObject());
    }
}
````
Quite similar on method level:
````java
public class GenericTest
{
    // A Generic method example
    private static <T> void genericOutput(T obj)
    {
        System.out.println(obj.getClass().getName() + " = " + obj);
    }

    public static void main(String[] args)
    {
         // Calling generic method with Integer argument
        genericOutput(100);

        // Calling generic method with String argument
        genericOutput("test");
    }
}
````