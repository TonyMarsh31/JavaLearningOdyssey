package OptionalUpdate;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        //isEmpty() 判断是否为空
        Optional<Object> temp = Optional.empty();
        boolean isPresent = temp.isPresent();//判断value是否存在，存在为true,不存在false
        boolean isEmpty = temp.isEmpty();//判断value是否为空，空为true,⾮空为false
        System.out.println(isPresent + "," + isEmpty);
    }
}
