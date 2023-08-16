package streamapiExtended;

import methodsReference.Users;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Steam最终操作代码示例
 * 最终操作后，Steam会关闭，不能再进行其他操作。
 * 如果需要再次使用，需要重新创建Stream。
 * 由于该特性，本示例中的代码不适合测试运行,仅作为参考。
 */
public class FinalOperation {
    public static void main(String[] args) {

        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users("xxx", 30, 10000));
        usersList.add(new Users("yyy", 29, 8000));
        usersList.add(new Users("zzz", 22, 12000));
        usersList.add(new Users("张三", 21, 20000));
        usersList.add(new Users("李四", 32, 22000));
        usersList.add(new Users("李四", 32, 22000));
        Stream<Users> stream = usersList.stream();
        //1.全部匹配:返回boolean结果，需要Steam处理中的所有数据均满足条件，才返回true。
        boolean b1 = stream.allMatch((u) -> u.getAge() == 29);
        System.out.println(b1);

        //2.至少匹配一个
        boolean b2 = stream.anyMatch((u) -> u.getAge() == 29);
        System.out.println(b2);

        //3.检查都不匹配的
        boolean b3 = stream.noneMatch((u) -> u.getAge() == 35);
        System.out.println(b3);

        //4.返回第一个元素
        Optional<Users> first = stream.findFirst();
        System.out.println(first.get());

        //5.返回总条数
        long count = stream.count();
        System.out.println(count);

        //6.求最大值--方法体中定义比较规则，此处比较工资，这里可以用方法引用简化代码
        Optional<Users> max = stream.max((u1, u2) -> u1.getSalary() - u2.getSalary());
        System.out.println(max.get());

        //7.求最小值
        Optional<Users> min = stream.min(Comparator.comparingInt(Users::getSalary));
        System.out.println(min.get());

        //8.最常用的终止操作 -- 遍历foreach
        stream.forEach(System.out::println);

        //9.归约(统计操作)-计算总的工资
        Optional<Integer> reduce = stream.map(Users::getSalary).reduce(Integer::sum);
        System.out.println(reduce.get());

        //10.collect() 收集
        List<String> collect = stream
                .filter((u) -> u.getAge() >= 25)
                .map(Users::getName)
                .distinct()
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
