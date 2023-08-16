package UpdatesInInterface;

interface logging {
    //静态常量
    String ORACLE = "Oracle_Database";
    String MYSQL = "MySql_Database";

    //抽象方法
    void logInfo(String message);

    void getConnection();

    void closeConnection();
}

/**
 * 在之前，接口中仅可以声明抽象方法，和定义常量。
 * (实际这是JDK8版本以前的情况，在JDK8版本中，接口已经支持默认和静态方法，但这里不做演示)
 */
public class OldDays {
    public static void main(String[] args) {
        LogOracle log = new LogOracle();
        log.logInfo("test");
        System.out.println("-----------------");
        LogMySql log2 = new LogMySql();
        log2.logInfo("test2");
    }
}

final class LogOracle implements logging {
    @Override
    public void logInfo(String message) {
        System.out.println(ORACLE);
        getConnection();
        System.out.println("Log Message : " + message + "\tINFO");
        closeConnection();
    }

    @Override
    public void getConnection() {
        System.out.println("Open Database connection");
    }

    @Override
    public void closeConnection() {
        System.out.println("Close Database connection");
    }
}

final class LogMySql implements logging {
    @Override
    public void logInfo(String message) {
        System.out.println(MYSQL);
        getConnection();
        System.out.println("Log Message : " + message + "\tINFO");
        closeConnection();
    }

    @Override
    public void getConnection() {
        System.out.println("Open Database connection");
    }

    @Override
    public void closeConnection() {
        System.out.println("Close Database connection");
    }
}