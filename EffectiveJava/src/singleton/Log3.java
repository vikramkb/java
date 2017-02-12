package singleton;

public enum Log3 {
    //compiler converts the INSTANCE similar to like this.
    //public final static Log3 INSTANCE = new Log3();
    INSTANCE;
    private Log3() {
        System.out.println("Log3 enum is called...");
    }
    public void info(String message) {

    }
    public void debug(String message) {

    }
    public void warn(String message) {

    }
}
