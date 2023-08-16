package OptionalClass;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        Integer value1 = null;
        Integer value2 = 10;

        //Optional.ofNullable - 允许传递为null的参数
        Optional<Integer> a = Optional.ofNullable(value1);

        //Optional.of - 如果传递的参数是null，抛出空指针异常
        Optional<Integer> b = Optional.of(value2);

        System.out.println(demo.sum(a, b));

    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - 判断是否有值
        System.out.println("第一个参数存在吗:\t" + a.isPresent());
        System.out.println("第二个参数存在吗:\t" + b.isPresent());

        //Optional.orElse - 如果有值，返回值，否则返回默认值
        Integer value1 = a.orElse(0);

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();

        return value1 + value2;

    }
}
