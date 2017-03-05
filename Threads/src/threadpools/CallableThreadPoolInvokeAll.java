package threadpools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Printer2 {
    synchronized static boolean print(String message) throws InterruptedException {
        Thread.sleep(200);
        System.out.println(Thread.currentThread().getId() + " " + message);

        //randomly returning the print status
        return Math.random() > 0.5;
    }
}

class PrinterThread2 implements Callable {
    //Message to be printed
    private String message;

    public PrinterThread2(String message) {
        this.message = message;
    }

    @Override
    public Object call() {
        try {
            return Printer2.print(message);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getId() + " is interrupted");
        }
        return false;
    }
}

public class CallableThreadPoolInvokeAll {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int numThreads = 3;
        System.out.println("Started thread pool with " + numThreads + " threads");
        ExecutorService printTaskPool = Executors.newFixedThreadPool(numThreads);

        List<Callable<Integer>> callables = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
             callables.add(new PrinterThread2("Hello - task index = " + i));
        }

        System.out.println("Invoking 50 printing tasks all at once using " + numThreads + " threads");
        List<Future<Integer>> futureThreadReturn = printTaskPool.invokeAll(callables);
        System.out.println("Printing status of all 50 theads.");
        for(Future<Integer> futureStatus : futureThreadReturn) {
            if(futureStatus.isDone() || futureStatus.isCancelled())
                System.out.println("Thread : status = " + futureStatus.get() + " ,isDone =" + futureStatus.isDone() + " ,isCancelled = " + futureStatus.isCancelled());
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
