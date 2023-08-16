package DefaultMethodInInterface;

public class MyAbstractClass implements MyInterface {
    // 没有任何实现，直接只用默认和静态方法

    public static void main(String[] args) {
        System.out.println(MyInterface.getStaticName());
        System.out.println(new MyAbstractClass().getName());
    }
}
