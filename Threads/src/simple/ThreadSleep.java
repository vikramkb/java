package simple;

public class ThreadSleep implements Runnable{
    @Override
    public void run() {
        for(int i=0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ": i = " + i);
                System.out.println("Thread sleeping for 1 second");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadSleep()).start();
        System.out.println(Thread.currentThread().getName() + ": running");
    }
}
