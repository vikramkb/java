package singleton;

import reflection.Reflection;

import java.lang.reflect.InvocationTargetException;


public class Log1SingletonReflectionAttack {
    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Log1 l1 = Log1.getInstance();
        Log1 l2 = Log1.getInstance();
        if(l1 == l2) {
            System.out.println("singleton is successful");
        }else{
            System.out.println("singleton is failed");
        }

        Log1 l3 = Reflection.getLog1();
        if(l1 == l3) {
            System.out.println("reflection: singleton successful");
        }else{
            System.out.println("reflection: singleton failed");
        }

    }
}
