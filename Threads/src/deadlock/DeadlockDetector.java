package deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector {
    String first = "No ";
    String second = "Lock";

    Thread thread1 = new Thread("My Thread 1"){
        public void run(){
            synchronized(first){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + ", Lock(first) = " + Thread.currentThread().holdsLock(first) + ", Lock(second) = " +  Thread.currentThread().holdsLock(second) + " is running");
                synchronized(second){
                    System.out.println(first + second);
                }
            }
        }
    };

    Thread thread2 = new Thread("My Thread 2"){
        public void run(){
            synchronized(second){
                System.out.println(Thread.currentThread().getId() + ", Lock(first) = " + Thread.currentThread().holdsLock(first) + ", Lock(second) = " +  Thread.currentThread().holdsLock(second) + " is running");
                synchronized(first){
                    System.out.println(second + first);
                }
            }
        }
    };

    public static void main(String a[]) throws InterruptedException {
        DeadlockDetector mdl = new DeadlockDetector();
        mdl.thread1.start();
        mdl.thread2.start();
        Thread.sleep(3000);

        ThreadMXBean threadMXBean =
                ManagementFactory.getThreadMXBean();
        long[] deadlockThreads = threadMXBean.findDeadlockedThreads();
        for(long threadId: deadlockThreads) {
            System.out.println("Deadlock Threads = " + threadId);
        }
    }
}
