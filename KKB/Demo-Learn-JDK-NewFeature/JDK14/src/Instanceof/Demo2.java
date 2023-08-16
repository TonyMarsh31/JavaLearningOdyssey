package Instanceof;

public class Demo2 {
    public static void main(String[] args) {
        Object obj = new String("abc");
        if (obj instanceof String str) {
            System.out.println(str.toUpperCase());//这⾥可以访问str
        } else {
            //System.out.println(str.toUpperCase()); //这⾥的str会报错，因为上⾯定义的str仅限于if语句
            System.out.println("不是字符串");
        }
    }
}
