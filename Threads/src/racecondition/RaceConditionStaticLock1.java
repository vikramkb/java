package racecondition;

class Log2 {

    private static Log2 instance;
    synchronized public static Log2 getInstance() throws InterruptedException {
        if(instance == null) {
            System.out.println("new instance created");
            instance = new Log2();
        }
        return instance;
    }
}


public class RaceConditionStaticLock1 implements Runnable{
    public static void main(String[] args) throws Exception {
        for(int i=0; i < 100; i++) {
            new Thread(new RaceConditionStaticLock1()).start();
        }
    }

    @Override
    public void run() {
        try {
            Log1.getInstance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
