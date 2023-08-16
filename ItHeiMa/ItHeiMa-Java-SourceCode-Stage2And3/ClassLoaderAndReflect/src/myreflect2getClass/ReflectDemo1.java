package myreflect2getClass;

/**
 * 获取class对象的三种方式
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.Class类中的静态方法forName("全类名")
        // 全类名:包名 + 类名
        Class<?> myClass1 = Class.forName("myreflect2getClass.Student");

        // 2.通过class属性来获取
        Class<Student> myClass2 = Student.class;

        // 3.利用对象的getClass方法来获取class对象
        // getClass方法是定义在Object类中.
        Student s = new Student();
        Class<? extends Student> myClass3 = s.getClass();

        // 验证三个对象是否是同一个对象
        // 由于方法2和3已经显式声明获取的是Student的class类对象，所以myClass2 == myClass3恒为true，
        // 我们只要比较这两个对象和myClass1是否相等即可
        System.out.println(myClass1 == myClass2 & myClass1 == myClass3);
        // 或者直接打印
        System.out.println(myClass1);
        System.out.println(myClass2);
        System.out.println(myClass3);
    }
}
