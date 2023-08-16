package myreflect3getConstrucrtor;

import java.lang.reflect.Constructor;

/**
 * 获取Constructor对象
 */

public class GetConstructor {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        method1(); // 返回所有公共的(public)
        method2(); // 返回所有
        method3(); // 返回单个公共的(public)
        method4(); // 返回单个
    }

    private static void method1() throws ClassNotFoundException {
        // Constructor<?>[] getConstructors()： 返回所有公共构造方法对象的数组
        //1.获取Class对象
        Class<?> clazz = Class.forName("myreflect3getConstrucrtor.Student");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }

    private static void method2() throws ClassNotFoundException {
        // Constructor<?>[] getDeclaredConstructors()：   返回所有构造方法对象的数组
        //1.获取Class对象
        Class<?> clazz = Class.forName("myreflect3getConstrucrtor.Student");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }

    private static void method3() throws ClassNotFoundException, NoSuchMethodException {
        // Constructor<T> getConstructor(Class<?>... parameterTypes)： 返回单个公共构造方法对象
        //1.获取Class对象
        Class<?> clazz = Class.forName("myreflect3getConstrucrtor.Student");
        //小括号中,一定要跟构造方法的形参保持一致.
        //获取无参构造方法
        Constructor<?> constructor1 = clazz.getConstructor();
        System.out.println(constructor1);
        //获取参数为String,int的构造方法
        Constructor<?> constructor2 = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor2);
    }

    private static void method4() throws ClassNotFoundException, NoSuchMethodException {
        // Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)： 返回单个构造方法对象
        //1.获取Class对象
        Class<?> clazz = Class.forName("myreflect3getConstrucrtor.Student");
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        System.out.println(constructor);
    }
}
