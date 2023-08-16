package ShowCodeDetailsInExceptionMessages;

/**
 * 通过添加JVM参数-XX:+ShowCodeDetailsInExceptionMessages可以在异常消息中显示源代码详情。
 */
public class ExceptionCanShowMoreDetailsNow {
    public static void main(String[] args) {
        Users users = new Users();
        users.passWord = "123";
        if (users.userName.equals("admin") && users.passWord.equals("123")) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
}

class Users {
    public String userName;
    public String passWord;
}