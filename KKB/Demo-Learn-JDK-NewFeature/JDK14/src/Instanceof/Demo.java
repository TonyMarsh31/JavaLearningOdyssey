package Instanceof;

public class Demo {
    public static void main(String[] args) {
        //jdk14以前的写法
        Object obj = new String("abc");//多态的写法
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println("是字符串" + str);
        } else {
            System.out.println("不是字符串");
        }

        //jdk14的写法
        if (obj instanceof String str1) { //省略了强制类型转换的过程
            System.out.println(str1);
        } else {
            System.out.println("不是字符串");
        }
    }
}
