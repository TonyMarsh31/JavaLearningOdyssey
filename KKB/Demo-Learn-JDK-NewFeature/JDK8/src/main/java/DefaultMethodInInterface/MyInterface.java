package DefaultMethodInInterface;

public interface MyInterface {
    static String getStaticName() {
        return "StaticMethodInInterface.MyInterface";
    }

    default String getName() {
        return "DefaultMethodInInterface.MyInterface";
    }
}
