package bean;

public class UserInModuleA {
    private String username;
    private String sex;

    public UserInModuleA() {
    }

    public UserInModuleA(String username, String sex) {
        this.username = username;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
