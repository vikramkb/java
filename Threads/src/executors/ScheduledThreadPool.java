package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Printer3 {
    synchronized static boolean print(String message) throws InterruptedException {
        Thread.sleep(200);
        System.out.println("Thread id : " + Thread.currentThread().getId() + " " + message);

        //randomly returning the print status
        return Math.random() > 0.5;
    }
}

class PrinterThread3 implements Callable {
    //Message to be printed
    private String message;

    public PrinterThread3(String message) {
        this.message = message;
    }

    @Override
    public Object call() {
        try {
            return Printer3.print(message);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getId() + " is interrupted");
        }
        return false;
    }
}

public class ScheduledThreadPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int numThreads = 2;
        System.out.println("Started scheduled thread pool with " + numThreads + " threads");
        ScheduledExecutorService printTaskPool = Executors.newScheduledThreadPool(numThreads);

        System.out.println("Check the order of print tasks in code and in output");
        printTaskPool.schedule(new PrinterThread3("Hello - after 5 seconds"), 5000, TimeUnit.MILLISECONDS);
        printTaskPool.schedule(new PrinterThread3("Hello - after 2 seconds"), 2000, TimeUnit.MILLISECONDS);
        printTaskPool.schedule(new PrinterThread3("Hello - after 4 seconds"), 4000, TimeUnit.MILLISECONDS);
        printTaskPool.schedule(new PrinterThread3("Hello - after 3 seconds"), 3000, TimeUnit.MILLISECONDS);
        printTaskPool.schedule(new PrinterThread3("Hello - after 1 seconds"), 1000, TimeUnit.MILLISECONDS);

        printTaskPool.shutdown();
        System.out.println("Thread pool will shutdown as soon as all the print tasks competed");
   }
}