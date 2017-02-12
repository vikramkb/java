package executors;


import java.util.concurrent.*;

class Printer1 {
    synchronized static boolean print(String message) throws InterruptedException {
        Thread.sleep(200);
        System.out.println(Thread.currentThread().getId() + " " + message);
        return Math.random() > 0.5;
    }
}

class PrinterThread1 implements Callable {
    private String message;

    public PrinterThread1(String message) {
        this.message = message;
    }

    @Override
    public Object call() {
        try {
            return Printer1.print(message);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getId() + " is interrupted");
        }
        return false;
    }
}

public class CallableThreadPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int numThreads = 3;
        System.out.println("Started thread pool with " + numThreads + " threads");
        ExecutorService printTaskPool = Executors.newFixedThreadPool(numThreads);

        System.out.println("Starting 1000 printing tasks with " + numThreads + " threads");
        Future<Integer>[] futureThreadReturn = new Future[1000];
        for(int i = 0; i < 1000; i++) {
            futureThreadReturn[i] = printTaskPool.submit(new PrinterThread1("Hello - task index = " + i));
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
            for(int i=0; i < 1000; i++) {
                if(futureThreadReturn[i].isDone() || futureThreadReturn[i].isCancelled())
                    System.out.println("Thread : status = " + futureThreadReturn[i].get() + " ,isDone =" + futureThreadReturn[i].isDone() + " ,isCancelled = " + futureThreadReturn[i].isCancelled());
            }

        }

    }
}
