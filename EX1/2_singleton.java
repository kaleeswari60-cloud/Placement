class MyLogger {
    private static MyLogger instance;
    private MyLogger() {}
    public static MyLogger getInstance() {
        if (instance == null) instance = new MyLogger();
        return instance;
    }
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
class SingletonDemo {
    public static void main(String[] args) {
        MyLogger logger1 = MyLogger.getInstance();
        MyLogger logger2 = MyLogger.getInstance();
        logger1.log("Application started");
        logger2.log("User logged in");
        System.out.println("Are both loggers same? " + (logger1 == logger2));
    }
}
