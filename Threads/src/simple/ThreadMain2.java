package simple;

public class ThreadMain2 implements Runnable{

    @Override
    public void run() {
        System.out.println("thread running ........ ");
    }

    public static void main(String[] args) {
        new Thread(new ThreadMain2()).start();
    }
}
