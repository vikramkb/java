package simple;

class Counter {
    private int c = 0;
    void increment() {
        c++;
    }
    void decrement() {
        c--;
    }
    public int getC() {
        return c;
    }
}
public class ThreadInteference implements Runnable{
    private static Counter counter = new Counter();
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
        new Thread(new ThreadInteference()).start();
        new Thread(new ThreadInteference()).start();
    }
}
