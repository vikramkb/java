package simple;

public class ThreadMain1 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread running .....");;
    }

    public static void main(String[] args) {
        new ThreadMain1().start();
    }
}
