package myreflect4getField;

import java.lang.reflect.Field;

/**
 * 利用Field对象,获取值或者修改值
 */

public class UseField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        method1(); // 赋值
        method2(); // 获取值
    }

    private static void method1() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //void set(Object obj, Object value)：给obj对象的成员变量赋值为value
        //1.获取class对象
        Class<?> clazz = Class.forName("myreflect4getField.Student");
        //2.获取name这个Field对象
        Field field = clazz.getField("name");
        //3.利用set方法进行赋值,但是赋值操作的对象应该是一个类而不是Class，（set方法的第一个参数是一个普通对象而不是字节码文件class类对象）
        // 所以为了演示，我们先通过class创建一个对应的对象
        //3.1先创建一个Student对象
        Student student = (Student) clazz.newInstance();
        //3.2有了对象才可以给指定对象进行赋值
        field.set(student, "zhangsan");
        System.out.println(student);
    }

    private static void method2() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //1.获取class对象
        Class<?> clazz = Class.forName("myreflect4getField.Student");
        //2.获取成员变量Field的对象
        Field field = clazz.getDeclaredField("money");
        //3.取消一下访问检查
        field.setAccessible(true);
        //4.调用get方法来获取值，同样的，我们获取的是一个已存在的对象的对应field属性的值，而不是字节码文件对象Class本身，所以我们先创建一个对象
        //4.1创建一个对象
        Student student = (Student) clazz.newInstance();
        //4.2获取指定对象的money的值
        Object o = field.get(student);
        //5.打印一下
        System.out.println(o);
    }
}
