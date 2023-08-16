package NewMethodsForString;

public class Demo {
    public static void main(String[] args) {
        //.isBlank() 判断字符串是否为空⽩(会去除\t,\n的效果)
        System.out.println("\t".isBlank());

        //trim()可以去除字符串前后的半⻆空⽩字符
        System.out.println("\tabc\t".trim() + "--->");

        //strip()可以去除字符串前后的全⻆和半⻆空⽩字符
        System.out.println("\tabc\t".strip() + "--->");

        //stripLeading() 去除头部空格
        System.out.println("\t\tabc2\t\t".stripLeading() + "--->");

        //stripTrailing() 去除尾部空格
        System.out.println("\t\tabc1\t\t".stripTrailing() + "--->");

        //repeat(重复次数)
        System.out.println("abc".repeat(2));

        //⾏数:lines().count()
        System.out.println("aa\naa".lines().count());
    }
}
