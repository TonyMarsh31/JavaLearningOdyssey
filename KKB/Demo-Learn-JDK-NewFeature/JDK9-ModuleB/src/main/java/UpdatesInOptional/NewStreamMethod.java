package UpdatesInOptional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewStreamMethod {
    public static void main(String[] args) {
        //Optional类直接使用stream方法转为Stream对象
        Optional<String> optional = Optional.of("aaa");
        optional.stream().forEach(System.out::println);

        //当然实际的场景中可能会这么使用
        List<Optional<String>> list = Arrays.asList(
                Optional.empty(),
                Optional.of("A"),
                Optional.empty(),
                Optional.of("B"));
        //老的版本中，将Optional转为Stream需要调用Steam的静态方法of(),并手动去除空值
        List<String> filteredList = list.stream()
                .flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
                .collect(Collectors.toList());

        //现在直接使用Optional的静态方法stream即可返回的是一个Stream对象
        //当Optional类是empty，stream方法会返回一个空的Stream对象
        List<String> filteredListJava9 = list.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        //校验结果
        System.out.println(filteredList);
        System.out.println(filteredListJava9);
    }
}
