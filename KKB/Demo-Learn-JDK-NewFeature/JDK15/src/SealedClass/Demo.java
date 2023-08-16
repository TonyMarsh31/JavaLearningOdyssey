package SealedClass;

public class Demo {
    /**
     * 引⼊了sealed class或interfaces。
     * 这些class或者interfaces只允许被permits的class或者interface进⾏扩展和实现。
     * 原则上子类需要是final或sealed class，以实现限制⼦类集的目的。
     * 但子类也可以用non-sealed修饰，作为取消sealed机制的选项
     */
    sealed class Person permits U1, U2, U3 {
    } //⽗类

    final class U1 extends Person {
    } //⼦类1

    final class U2 extends Person {
    } //⼦类2

    non-sealed class U3 extends Person {
    } //⼦类3

    class User1 extends U1 {
    } //孙⼦类1

    class User2 extends U3 {
    } //孙⼦类2
}
