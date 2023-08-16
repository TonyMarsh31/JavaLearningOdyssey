package ModuleTest;

import bean.UserInModuleA;

public class TestJDKModule {
    public static void main(String[] args) {
        UserInModuleA tempUser = new UserInModuleA("张伟", "男");
        System.out.println(tempUser.getUsername() + " " + tempUser.getSex());
    }
}
