package lambda.streamapi.useStrategePattern;

import lambda.streamapi.User;
import lambda.streamapi.useStrategePattern.filter.MyFilter;
import lambda.streamapi.useStrategePattern.filter.impl.SalaryFilter;

import java.util.ArrayList;
import java.util.List;

public class ImprovedCase {
    //限定年龄或工资
    public static List<User> filter(List<User> list, MyFilter<User> myFilter) {
        List<User> newList = new ArrayList<>();
        for (User user : list) {
            if (myFilter.filter(user)) {
                newList.add(user);
            }
        }
        return newList;
    }


    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("aa", 18, 900));
        list.add(new User("aa2", 25, 2000));
        list.add(new User("aa3", 30, 3000));
        list.add(new User("aa4", 18, 4000));
        list.add(new User("aa5", 29, 5000));
        //限定出大于25岁的用户
        //List<User> selectedList = filter(list, new AgeFilter());
        //限定出薪水大于1000的用户
        List<User> selectedList = filter(list, new SalaryFilter());
        for (Object o : selectedList) {
            System.out.println(o);
        }
    }
}
