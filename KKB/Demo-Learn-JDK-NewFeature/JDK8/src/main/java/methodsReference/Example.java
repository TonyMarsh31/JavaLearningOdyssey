package methodsReference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Example {
    public static void main(String[] args) {
        // - 1对象::实例⽅法
        //lambda表达式中的⽅法体中只调⽤了⼀个⽅法，⽽且这个⽅法的参数和
        //返回值类型和lambda表达表示的抽象⽅法的参数和返回值类型相同
        //Consumer中的⽅法:void accept(T t)
        //Consumer<String> con=s->System.out.println(s);
        //等价于
        Consumer<String> con = System.out::println;
        con.accept("我爱编程");
        con.accept("我爱java");

        List<String> names = new ArrayList<>();
        names.add("xxxx");
        names.add("yyyy");
        names.add("zzzz");
        names.add("abc");

        //names.forEach(s->System.out.println(s));
        names.forEach(System.out::println);


        // - 2类::静态⽅法
        //lambda表达式中的⽅法体中只调⽤了⼀个⽅法，⽽且这个⽅法的参数和
        //返回值类型和lambda表达表示的抽象⽅法的参数和返回值类型相同
        //Comparator中的⽅法: int compare(T o1, T o2);
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        //等价于
        Comparator<Integer> comparator2 = Integer::compare;
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);

        // - 3类::实例⽅法
        //1 lambda表达式中的⽅法体中只调⽤了⼀个⽅法
        //2 第⼀个参数作为⽅法的调⽤者，第⼆个参数作为⽅法的参数
        //BiPredicate中的⽅法: boolean test(T t, U u);
        BiPredicate<String, String> pre = (s1, s2) -> s1.equals(s2);
        //等价于
        BiPredicate<String, String> pre2 = String::equals;
        boolean b = pre2.test("haha", "haha");
        System.out.println(b);


        // - 4类::new
        //lambda表达式的⽅法体内只有对象的创建，
        //并且类型和lambda表达式表示的抽象⽅法的返回值类型相同
        //Supplier中的⽅法:T get();
        Supplier<Employee> sup = () -> new Employee();
        //等价于
        //思考问题?调⽤是什么构造⽅法(⽆参构造⽅法)
        Supplier<Employee> sup2 = Employee::new;
        Employee employee = sup2.get();
        System.out.println(employee.toString());
        //4.1 调⽤指定的构造⽅法 (带参构造 String int)-需要⾃定义接⼝
        MySupplier<Employee> sup3 = Employee::new;
        Employee employee2 = sup3.get("李四", 30);
        System.out.println(employee2.toString());

        //5数组引⽤
        MyArray<String> myArray = (n) -> new String[n];
        //等价于
        MyArray<String> myArray2 = String[]::new;
        String[] strings = myArray2.get(10);
        System.out.println(strings.length);
    }
}
