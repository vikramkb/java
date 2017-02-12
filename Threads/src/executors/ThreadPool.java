package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer {
    synchronized static void print() throws InterruptedException {
        Thread.sleep(200);
        System.out.println(Thread.currentThread().getId() + " printing");
    }
}

class PrinterThread implements Runnable {
    @Override
    public void run() {
        try {
            Printer.print();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getId() + " interrupted");
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 3;
        System.out.println("Started thread pool with " + numThreads + " threads");
        ExecutorService printTaskPool = Executors.newFixedThreadPool(numThreads);

        System.out.println("Starting 1000 printing tasks with " + numThreads + " threads");
        for(int i = 0; i < 1000; i++) {
            printTaskPool.submit(new Thread(new PrinterThread()));
        }

        Thread.sleep(2000);
        System.out.println("Try shutdown: wait for all threads to complete for 3 second");
        printTaskPool.shutdown();
        try {
            printTaskPool.awaitTermination(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("Tasks interrupted");
        }finally {
            System.out.println("Enough. Shutdown thread pool anyway");
            printTaskPool.shutdownNow();
        }
    }
}
