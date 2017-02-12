package singleton;

import reflection.Reflection;
import serialization.Serialization;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Log3SingletonReflectionSafePreferred {
    public static void main(String args[]){
        Log3 l1 = Log3.INSTANCE;
        Log3 l2 = Log3.INSTANCE;
        if(l1 == l2) {
            System.out.println("singleton is successful");
        }else{
            System.out.println("singleton is failed");
        }

        Log3 l3 = null;
//        try {
//            l3 = Reflection.getLog3();
//        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
//            System.out.println("Reflection can not be done on Enum");
//        }

        try {
            Serialization.serializeLog2Out(l2);
            l3 = Serialization.serializeLog3In();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(l1 == l3) {
            System.out.println("serialization: enum singleton successful");
        }else{
            System.out.println("serialization: enum singleton failed");
        }
    }
}
