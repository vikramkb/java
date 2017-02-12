package singleton;

import reflection.Reflection;
import serialization.Serialization;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Log2SingletonSerialization {
    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        Log2 l1 = Log2.getInstance();
        Log2 l2 = Log2.getInstance();
        if(l1 == l2) {
            System.out.println("singleton is successful");
        }else{
            System.out.println("singleton is failed");
        }
        Serialization.serializeLog2Out(l2);
        Log2 l3 = Serialization.serializeLog2In();

        if(l1 == l3) {
            System.out.println("Serialization: singleton successful");
        }else{
            System.out.println("Serialization: singleton failed");
        }

    }
}
