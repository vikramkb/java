package racecondition;

/**
 * ThreadLocal make the state local within the thread.
 * static ThreadLocal state is same within the thread.
 * non static ThreadLocal state is different for each thread. And also different for each instance.
 * static sate is same across all threads
 * non statis state can be shared between across different threads.
 */
public class ThreadLocalMain implements Runnable{
    public static void main(String[] args) {
        ThreadLocalMain sameInstance = new ThreadLocalMain();
        new Thread(sameInstance).start();
        new Thread(sameInstance).start();
        new Thread(new ThreadLocalMain()).start();
    }

    private ThreadLocal localToEachThread = new ThreadLocal<Test>() {
        @Override
        protected Test initialValue() {
            return new Test();
        }
    };
    private static ThreadLocal globalToEachThread = new ThreadLocal<Test>() {
        @Override
        protected Test initialValue() {
            return new Test();
        }
    };
    private static Test allThreadsShared = new Test();
    private Test instanceThreadShared = new Test();

    @Override
    public void run() {
        ThreadLocalMain obj2 = new ThreadLocalMain();
        synchronized (lock) {
            System.out.println("-----------------------------");
            System.out.println(Thread.currentThread() + ": diff instance within thread [obj1, obj2]= [" + localToEachThread.get() + ", " + obj2.localToEachThread.get() + "]");
            System.out.println(Thread.currentThread() + ": same instance within the thread [obj1, obj2]= [" + globalToEachThread.get() + ", " + obj2.globalToEachThread.get() + "]");
            System.out.println(Thread.currentThread() + ": can be same instance between diff threads  [obj1, obj2]= [" + instanceThreadShared + ", " + obj2.instanceThreadShared + "]");
            System.out.println(Thread.currentThread() + ": same instance across all threads [obj1, obj2]= [" + allThreadsShared + ", " + obj2.allThreadsShared + "]");
        }
    }

    static Integer lock = new Integer(1);
}

class Test {
    OtherObject OtherObject = new OtherObject();

    @Override
    public String toString() {
        return Integer.toString(OtherObject.hashCode());
    }
}

class OtherObject {

}