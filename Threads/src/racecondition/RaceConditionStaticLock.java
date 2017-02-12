package racecondition;

class Log1 {

    private static Log1 instance;
    public static Log1 getInstance() throws InterruptedException {
        synchronized (Log1.class) {
            if(instance == null) {
                System.out.println("new instance created");
                instance = new Log1();
            }
            return instance;
        }
    }
}

public class RaceConditionStaticLock implements Runnable{
    public static void main(String[] args) throws Exception {
        for(int i=0; i < 100; i++) {
            new Thread(new RaceConditionStaticLock()).start();
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
