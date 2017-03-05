package atomic;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class Count {
    private AtomicInteger intCount = new AtomicInteger();
    private AtomicBoolean boolCount = new AtomicBoolean();
    private AtomicLong longCount = new AtomicLong();

    Count() {
        intCount.set(100);
        boolCount.set(false);
        longCount.set(200);
    }
    public void increment() {
        intCount.getAndIncrement();
        boolCount.getAndSet(true);
        longCount.getAndIncrement();
    }

    public void decrement() {
        intCount.getAndDecrement();
        boolCount.getAndSet(false);
        longCount.getAndDecrement();
    }

    @Override
    public String toString() {
        return "Atomic int count = " + intCount.toString() + "\n" +
        "Atomic bool status = " + boolCount.toString() + "\n" +
        "Atomic long count = " + longCount.toString() + "\n";
    }
}

class CoinCount implements Callable {
    public static Count count = new Count();
    private boolean isIncrement;

    public CoinCount(boolean isIncrement) {
        this.isIncrement = isIncrement;
    }

    @Override
    public Integer call() {
        if(isIncrement){
            count.increment();
        }else {
            count.decrement();
        }
        return 0;
    }
}

public class AtomicTypes {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Initial values before thread operations");
        System.out.println(CoinCount.count);
        System.out.println("Should be same as initial values after same number of increments and decrements");

        List<Callable<Integer>> threads = new LinkedList<>();
        for(int i=0; i < 10000; i++)
            threads.add(new CoinCount((i%2)==0));
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        threadPool.invokeAll(threads);

        Thread.sleep(1000);
        System.out.println(CoinCount.count);
        Thread.sleep(1000);
        System.out.println(CoinCount.count);
        Thread.sleep(1000);
        System.out.println(CoinCount.count);
        threadPool.shutdown();
    }
}
