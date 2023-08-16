package myclassloader;

/**
 * 获取类加载器
 */
public class ClassLoaderDemo1 {
    public static void main(String[] args) {
        //Bootstrap class loader：虚拟机的内置类加载器，通常表示为null ，并且没有父null
        //Platform class loader：平台类加载器,负责加载JDK中一些特殊的模块
        //System class loader：系统类加载器,负责加载用户类路径上所指定的类库
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        //获取系统类加载器的父加载器 --- 平台类加载器
        ClassLoader classLoader1 = systemClassLoader.getParent();

        //获取平台类加载器的父加载器 --- 启动类加载器
        ClassLoader classLoader2 = classLoader1.getParent();

        System.out.println("系统类加载器" + systemClassLoader);
        System.out.println("平台类加载器" + classLoader1);
        System.out.println("启动类加载器" + classLoader2);

    }
}
