package lambda.streamapi.useStreamApi;

import lambda.streamapi.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用StreamApi来用函数式编程的思想处理数据，相较于前面两个包(案例)中的代码，使用StreamApi更加简洁
 */
public class ImprovedByStreamApiAndMethodReference {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("aa", 18, 900));
        list.add(new User("aa2", 25, 2000));
        list.add(new User("aa3", 30, 3000));
        list.add(new User("aa4", 18, 4000));
        list.add(new User("aa5", 29, 5000));

        //限定出大于25岁的用户
        list.stream().filter(user -> user.getAge() > 25).forEach(System.out::println);
        System.out.println("------------------------------");
        //限定出薪水大于1000的用户
        list.stream().filter(user -> user.getSalary() > 1000).forEach(System.out::println);

    }
}
