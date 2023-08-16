package UpdatesInInterface;

interface Logging8 {
    String ORACLE = "Oracle_Database";
    String MYSQL = "MySql_Database";

    static void getConnection() {
        System.out.println("Open Database connection");
    }

    static void closeConnection() {
        System.out.println("Close Database connection");
    }

    /**
     * default using mysql
     */
    default void logInfo(String message) {
        getConnection();
        System.out.println("Log Message : " + MYSQL + "INFO");
        closeConnection();
    }
}

public class SameExampleInJDK8 {
    public static void main(String[] args) {
        LogOracle8 log = new LogOracle8();
        log.logInfo("");
        System.out.println("-----------------");
        LogMySql8 log1 = new LogMySql8();
        log1.logInfo("");
    }
}

final class LogOracle8 implements Logging8 {
    @Override
    public void logInfo(String message) {
        Logging8.getConnection();
        System.out.println("Log Message : " + ORACLE + "INFO");
        Logging8.closeConnection();
    }
}

final class LogMySql8 implements Logging8 {
    //use default method
}