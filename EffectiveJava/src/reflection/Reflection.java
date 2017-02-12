package reflection;

import singleton.Log;
import singleton.Log1;
import singleton.Log2;
import singleton.Log3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflection {
    public static Log getLog() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class l3C = Class.forName("singleton.Log");
        Constructor[] constructors = l3C.getDeclaredConstructors();
        constructors[0].setAccessible(true);
        Log log = (Log) constructors[0].newInstance(new Object[]{"abc"});
        return log;
    }

    public static Log1 getLog1() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class l3C = Class.forName("singleton.Log1");
        Constructor[] constructors = l3C.getDeclaredConstructors();
        constructors[0].setAccessible(true);
        Log1 log = (Log1) constructors[0].newInstance(new Object[]{"abc"});
        return log;
    }

    public static Log2 getLog2() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class l3C = Class.forName("singleton.Log2");
        Constructor[] constructors = l3C.getDeclaredConstructors();
        constructors[0].setAccessible(true);
        Log2 log = (Log2) constructors[0].newInstance(new Object[]{"abc"});
        return log;
    }

    /**
     * Cannot create the clone of enum type with reflection.
     * This will give the runtime exception "java.lang.IllegalArgumentException: Cannot reflectively create enum objects"
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static Log3 getLog3() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class l3C = Class.forName("singleton.Log3");
        Constructor[] constructors = l3C.getDeclaredConstructors();
        constructors[0].setAccessible(true);
        Log3 log = (Log3) constructors[0].newInstance();
        return log;
    }
}
