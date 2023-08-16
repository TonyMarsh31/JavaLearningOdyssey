package methodsReference;

public interface MySupplier<T> {
    T get(String name, int age); //参数列表的类型要和构造方法的类型相同
}
