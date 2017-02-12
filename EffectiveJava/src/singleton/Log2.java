package singleton;

import java.io.Serializable;

public class Log2 implements Serializable{
    /*no need to serialize this variable. Also use transient for any other instance variables.*/
    private static final transient Log2 instance = new Log2("info.log");
    private Log2(String filePath) {
        System.out.println("Log2 instance created");
    }

    public static Log2 getInstance() {
        return instance;
    }

    public void info(String message) {

    }
    public void debug(String message) {

    }
    public void warn(String message) {

    }

    /*
    This is called after readObject function while serializing object
    Used to replace the serialized object content
    In this case serialized object is replaced with singleton object
     */
    private Object readResolve() {
        return instance;
    }

}
