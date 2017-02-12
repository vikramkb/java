package simple;


/**
 * Execute thread T1 follwed by T2 followed by T2
 */
public class ThreadJoin implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread = " + Thread.currentThread().getId());

        Thread T1 = new Thread(new ThreadJoin());
        System.out.println("T1 = " + T1.getId());

        Thread T2 = new Thread(new ThreadJoin());
        System.out.println("T2 = " + T2.getId());

        Thread T3 = new Thread(new ThreadJoin());
        System.out.println("T3 = " + T3.getId());

        T1.start();
        T1.join();
        T2.start();
        T2.join();
        T3.start();
        T3.join();
        System.out.println(Thread.currentThread().getId());
    }
}
