package streamapiExtended;

import methodsReference.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * StreamApi中间操作代码示例
 */
public class IntermediateOperation {
    public static void main(String[] args) {

        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users("xxx", 30, 10000));
        usersList.add(new Users("yyy", 29, 8000));
        usersList.add(new Users("zzz", 22, 12000));
        usersList.add(new Users("张三", 21, 20000));
        usersList.add(new Users("李四", 32, 22000));
        usersList.add(new Users("李四", 32, 22000));

        //1.过滤 - filter
        usersList.stream().filter((u) -> u.getAge() > 25).forEach(System.out::println);

        //2 分页(限制展示的数据量) - limit
        usersList.stream().limit(5).forEach(System.out::println);

        //3 跳过 - skip
        usersList.stream().skip(5).limit(5).forEach(System.out::println);

        //4 去重 - distinct
        List<String> list1 = new ArrayList<>();
        list1.add("abc");
        list1.add("abc1");
        list1.add("abc");
        list1.add("abc2");
        list1.stream().distinct().forEach(System.out::println);

        //5 映射(获取部分数据)-map(Function(T,R))
        usersList.stream().map(Users::getName).forEach(System.out::println);

        //6.排序 - sorted
        List<Integer> list2 = new ArrayList<>();
        list2.add(111);
        list2.add(4223);
        list2.add(2);
        list2.add(23);
        list2.add(3);
        list2.stream().sorted().forEach(System.out::println);
        //6.1 排序内容为自定义对象时 -- 定义排序规则
        usersList.stream().sorted((o1, o2) -> o2.getAge() - o1.getAge()).forEach(System.out::println);

    }
}
