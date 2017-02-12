package singleton;

public class Log {
    public static final Log instance = new Log("info.log");
    private Log(String filePath) {
        System.out.println("instance created");
    }

    public void info(String message) {

    }
    public void debug(String message) {

    }
    public void warn(String message) {

    }
}
