package lambda.streamapi;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求是创建一个filter过滤一个List中的数据
 * 如果没有学习过lambda和stream api，那么你的代码将大概率是下面这样
 * 但当新filter的需求不断增加时，该如何是好？
 */
public class OriginCase {
    //过滤工资小于1000的数据
    public static List<User> filterSalary(List<User> list) {
        List<User> userList = new ArrayList<>();
        for (User users : list) {
            if (users.getSalary() >= 1000) {
                userList.add(users);
            }
        }
        return userList;
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("aa", 18, 900));
        list.add(new User("aa2", 25, 2000));
        list.add(new User("aa3", 30, 3000));
        list.add(new User("aa4", 18, 4000));
        list.add(new User("aa5", 29, 5000));

        //限定出工资大于1000的用户
        List<User> selectedList = filterSalary(list);

        for (User user : selectedList) {
            System.out.println(user);
        }
    }
}
