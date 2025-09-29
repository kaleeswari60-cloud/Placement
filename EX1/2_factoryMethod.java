interface Logger {
    void log(String message);
}
class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
class FileLogger implements Logger {
    public void log(String message) {
        System.out.println("FILE LOG: " + message);
    }
}
abstract class LoggerCreator {
    public abstract Logger createLogger();
    public void log(String message) {
        Logger logger = createLogger(); 
        logger.log(message);            
    }
}
class ConsoleLoggerCreator extends LoggerCreator {
    @Override
    public Logger createLogger() {
        return new ConsoleLogger();
    }
}
class FileLoggerCreator extends LoggerCreator {
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}
class FactoryMethodDemo {
    public static void main(String[] args) {
        LoggerCreator creator = new ConsoleLoggerCreator();
        Logger logger1 = creator.createLogger();
        Logger logger2 = creator.createLogger();
        logger1.log("Application started");
        logger2.log("User logged in");
        System.out.println("Are both loggers same? " + (logger1 == logger2));
        creator = new FileLoggerCreator();
        Logger fileLogger = creator.createLogger();
        fileLogger.log("Saving to file");
    }
}
