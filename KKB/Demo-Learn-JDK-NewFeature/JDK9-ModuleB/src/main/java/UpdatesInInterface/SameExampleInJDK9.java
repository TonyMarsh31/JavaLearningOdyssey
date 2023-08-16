package UpdatesInInterface;

interface Logging9 {
    String Open = "Open Database connection";
    String Close = "Close Database connection";

    private static void getConnection() {
        System.out.println(Open);
    }

    private static void closeConnection() {
        System.out.println(Close);
    }

    private void log(String message, String prefix) {
        getConnection();
        System.out.println(prefix + "Log Message : " + message + "\tINFO");
        closeConnection();
    }

    default void logInfo(String message, String prefix) {
        log(message, prefix);
    }
}

public class SameExampleInJDK9 {
    public static void main(String[] args) {
        LogOracle9 log = new LogOracle9();
        log.logInfo("test", "Oracle");
        System.out.println("-----------------");
        LogMySql9 log1 = new LogMySql9();
        log1.logInfo("test", "MySql");
    }
}

final class LogOracle9 implements Logging9 {
    //use default method
}

final class LogMySql9 implements Logging9 {
    //use default method
}