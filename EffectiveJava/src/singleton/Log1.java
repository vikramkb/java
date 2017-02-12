package singleton;

public class Log1 {
    private static final Log1 instance = new Log1("info.log");
    private Log1(String filePath) {
        System.out.println("Log1 instance created");
    }

    public static Log1 getInstance() {
        return instance;
    }

    public void info(String message) {

    }
    public void debug(String message) {

    }
    public void warn(String message) {

    }

}
