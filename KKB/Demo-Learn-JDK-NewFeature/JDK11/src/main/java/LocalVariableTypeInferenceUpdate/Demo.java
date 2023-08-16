package LocalVariableTypeInferenceUpdate;

import java.util.function.Consumer;

/**
 * 在var上添加注解的语法格式
 */
public class Demo {
    public static void main(String[] args) {
        //1.lambda表达式中，参数可以不指定参数类型
        Consumer<Object> consumer1 = (str) -> System.out.println(str);

        //2.lambda表达式中，参数如果想要加注解，则必须指定参数类型,且声明时必须加泛型
        //Consumer<String> consumer2 = (@SuppressWarnings("")str) -> System.out.println(str); (无法通过编译)
        Consumer<String> consumer2 = (@SuppressWarnings("") String str) -> System.out.println(str);

        //3.如果不想加泛型，则使⽤var
        Consumer<Object> consumer3 = (@SuppressWarnings("") var str) -> System.out.println(str);
        consumer3.accept("abc");
        consumer3.accept(123);
    }
}
