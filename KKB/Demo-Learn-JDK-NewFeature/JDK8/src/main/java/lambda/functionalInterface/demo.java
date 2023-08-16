package lambda.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java内置了四种类型的函数式接口来满足大部分的应用场景。
 * 当一个接口中存在多个抽象方法时，Lambda表达式将无法作用于这个接口来快速创建一个该接口的实现（因为无法决定实现哪一个）
 * 即Lambda表达式仅能作用于只含有一个方法的接口，java将这样的接口称为函数式接口。
 * 如要自定义函数式接口，最好使用@FunctionalInterface注解来确保接口中仅有一个方法
 *
 */
public class demo {
    //直接使用接口定义的抽象方法：

    //传递一个数据给Consumer接口的实现类
    public static void testConsumer(int money, Consumer<Object> consumer) {
        consumer.accept(money);
    }
    //从Supplier接口的实现类中获取数据
    public static List<Object> testSupplier(Supplier<Object> supplier) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(supplier.get());
        }
        return list;
    }
    //使用Predicate函数的实现类来进行判断，返回Boolean
    public static List<String> testPredicate(List<String> list, Predicate<String> predicate){
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) newList.add(s);
        }
        return newList;
    }



    public static void main(String[] args) {
        //使用lambda实现Consume函数式接口的accept方法,有参数无返回值
        Consumer<Object> consumer = (m) -> System.out.println("我消费了" + m);
        testConsumer(300, consumer);
        System.out.println("---------------");

        //使用lambda实现Supplier函数式接口的get方法,无参数有返回值
        Supplier<Object> supplier = () -> new Random().nextInt();
        List<Object> result = testSupplier(supplier);
        for (Object o : result) {
            System.out.println(o);
        }
        System.out.println("---------------");

        //使用lambda实现Predicate函数式接口的test方法，有参数，返回Boolean
        List<String> list=new ArrayList<>();
        list.add("abc");
        list.add("bcd");
        list.add("ccd");
        list.add("acd");
        list.add("acd2");
        List<String> resultList = testPredicate(list,(s)-> s.startsWith("a"));
        for (String s : resultList) {
            System.out.println(s);
        }
        System.out.println("---------------");

        //使用lambda实现Function函数式接口的apply方法,有参数有返回值
        //具体需求是将字符串转换为大写
        Function<String, String> myFunction = String::toUpperCase;
        System.out.println(myFunction.apply("abc"));
    }
}
