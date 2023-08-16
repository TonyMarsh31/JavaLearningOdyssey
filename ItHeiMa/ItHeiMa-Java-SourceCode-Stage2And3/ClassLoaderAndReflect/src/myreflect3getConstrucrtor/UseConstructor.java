package myreflect3getConstrucrtor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 获取Constructor对象并创建对象
 */

public class UseConstructor {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        method1(); // 无参构造方法
        method2(); // 有参构造方法
        method3(); // 介绍已过时的newInstance()方法，但是仍然可以使用
        method4(); // 使用私有构造方法

    }

    private static void method1() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1.获取class对象
        Class<?> clazz = Class.forName("myreflect3getConstrucrtor.Student");
        //2.获取构造方法对象
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        //3.利用newInstance()创建Student的对象
        Student student = (Student) constructor.newInstance("zhangsan", 23);
        System.out.println(student);
    }

    private static void method2() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1.获取class对象
        Class<?> clazz = Class.forName("myreflect3getConstrucrtor.Student");
        //2.获取构造方法对象
        Constructor<?> constructor = clazz.getConstructor();
        //3.利用空参来创建Student的对象
        Student student = (Student) constructor.newInstance();
        System.out.println(student);
    }

    private static void method3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //简写格式
        //1.获取class对象
        Class<?> clazz = Class.forName("myreflect3getConstrucrtor.Student");
        //2.在Class类中,有一个newInstance()方法,可以直接利用空参创建一个对象 但这个方法现在已经过时了,仅作为了解
        //也就是说，java不推荐直接通过class对象来构建对象，而是要先获取构造器，然后再通过构造器来构建对象
        // 但是该方法目前仅标记为过时，但没有弃用，也就说虽然java官方不推荐，但你还是可以直接用class对象newInstance
        Student student = (Student) clazz.newInstance();
        System.out.println(student);
    }

    private static void method4() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //获取一个私有的构造方法并创建对象
        //1.获取class对象
        Class<?> clazz = Class.forName("myreflect3getConstrucrtor.Student");
        //2.获取一个私有化的构造方法.
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        //3.暴力反射
        //虽然我们已经获取到了该私有构造方法，但是该方法是私有的，不能直接使用，所以要先暴力反射
        //即强行用反射获取并使用,具体的操作就是临时取消访问检查
        constructor.setAccessible(true);
        //4.创建对象
        Student student = (Student) constructor.newInstance("zhangsan");
        System.out.println(student);
    }
}
