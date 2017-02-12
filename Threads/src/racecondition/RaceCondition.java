package racecondition;

class Log {

    private static Log instance;
    public static Log getInstance() throws InterruptedException {
        if(instance == null) {
            System.out.println("new instance created");
            instance = new Log();
        }
        return instance;
    }
}
public class RaceCondition implements Runnable{
    public static void main(String[] args) throws Exception {
        for(int i=0; i < 100; i++) {
            new Thread(new RaceCondition()).start();
        }
    }

    @Override
    public void run() {
        try {
            Log.getInstance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
