package lambda;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 在集合中进行字符串排序
 */
public class intro2 {
    public static void main(String[] args) {
        //复习：compare()返回负数，0，正数
        //分别表示第一个参数 小于、等于、大于 第二个参数

        //还是老写法，匿名内部类
        //根据字符串长度升序排序
        Comparator<String> comparatorAsc = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        //lambda
        //根据字符串长度降序排序
        Comparator<String> comparatorDes = (o1, o2) -> o2.length() - o1.length();

        //测试
        ArrayList<String> test = new ArrayList<>();
        test.add("aaa");
        test.add("a");
        test.add("aa");
        test.sort(comparatorDes);
        for (String s : test) {
            System.out.println(s);
        }
    }
}
