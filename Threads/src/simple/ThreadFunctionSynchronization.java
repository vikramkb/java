package simple;

class Counter1 {
    private int c = 0;
//    When a thread invokes a synchronized method, it automatically acquires the intrinsic lock for that method's object and releases it when the method returns. The lock release occurs even if the return was caused by an uncaught exception.
    synchronized void increment() {
        c++;
    }
    synchronized void decrement() {
        c--;
    }
    public int getC() {
        return c;
    }
}

public class ThreadFunctionSynchronization implements Runnable{

    private static Counter1 counter = new Counter1();
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            counter.increment();
            counter.decrement();
        }
        System.out.println("count = " + counter.getC()); //memory in-consistency errors
    }

    public static void main(String[] args) {
//        Thread A: Retrieve c.
//        Thread B: Retrieve c.
//        Thread A: Increment retrieved value; result is 1.
//        Thread B: Decrement retrieved value; result is -1.
//        Thread A: Store result in c; c is now 1.
//        Thread B: Store result in c; c is now -1.
        System.out.println("counter should be zeror by last print");
        new Thread(new ThreadFunctionSynchronization()).start();
        new Thread(new ThreadFunctionSynchronization()).start();
        new Thread(new ThreadFunctionSynchronization()).start();
        new Thread(new ThreadFunctionSynchronization()).start();
    }
}
