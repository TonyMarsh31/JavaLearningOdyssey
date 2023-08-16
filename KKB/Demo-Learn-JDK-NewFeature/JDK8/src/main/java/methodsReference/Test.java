package methodsReference;


import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        //对象::实例方法
        //Consumer<String> c=(s)->System.out.println(s);
        //c.accept("abc");
        Consumer<String> c = System.out::println;
        c.accept("abcd");

        //类::静态方法
        //Comparator<Integer> comparator=(o1,o2)->Integer.compare(o1,o2);
        Comparator<Integer> comparator = Integer::compare;
        int rs = comparator.compare(10, 1);
        System.out.println(rs);

        //类::实例方法
        //BiPredicate<String,String> biPredicate=(s1,s2)->s1.equals(s2);
        BiPredicate<String, String> biPredicate = String::equals;
        boolean test = biPredicate.test("abc1", "abc");
        System.out.println(test);

        //类::new
        //Supplier<Users> supplier=()->new Users();
        Supplier<Users> supplier = Users::new;
        Users users = supplier.get();
        System.out.println(users);

        //数组引用
    }
}
