package atomic;

import java.util.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Count1 {
    private volatile int intCount = 0;
    private volatile boolean boolCount = false;
    private volatile long longCount = 0;

    Count1() {
        intCount = 100;
        boolCount = true;
        longCount = 200;
    }


    public void increment() {
        intCount++;
        boolCount = true;
        longCount++;
    }

    public void decrement() {
        intCount--;
        boolCount = false;
        longCount--;
    }

    @Override
    public String toString() {
        return "Non atomic int count = " + intCount + "\n" +
                "Non atomic bool status = " + boolCount + "\n" +
                "Non atomic long count = " + longCount + "\n";
    }
}

class CoinCount1 implements Callable {
    public static Count1 count = new Count1();
    private boolean isIncrement;

    public CoinCount1(boolean isIncrement) {
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

public class WithOutAtomicCount {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Initial values before thread operations");
        System.out.println(CoinCount1.count);
        System.out.println("Should be same as initial values after same number of increments and decrements");
        System.out.println("Run multiple types. If you are lucky sometimes you may get expected values.");

        List<Callable<Integer>> threads = new LinkedList<>();
        for(int i=0; i < 10000; i++)
            threads.add(new CoinCount1(i%2==0));
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        threadPool.invokeAll(threads);

        Thread.sleep(1000);
        System.out.println(CoinCount1.count);
        Thread.sleep(1000);
        System.out.println(CoinCount1.count);
        Thread.sleep(1000);
        System.out.println(CoinCount1.count);
        threadPool.shutdown();
    }
}
