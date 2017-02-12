package singleton;

import reflection.Reflection;

import java.lang.reflect.InvocationTargetException;


public class LogSingletonReflectionAttack {
    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Log l1 = Log.instance;
        Log l2 = Log.instance;
        if(l1 == l2) {
            System.out.println("singleton is successful");
        }else{
            System.out.println("singleton is failed");
        }

        Log l3 = Reflection.getLog();
        if(l1 == l3) {
            System.out.println("reflection: singleton successful");
        }else{
            System.out.println("reflection: singleton failed");
        }

    }
}
