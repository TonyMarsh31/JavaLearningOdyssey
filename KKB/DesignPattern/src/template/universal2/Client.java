package template.universal2;

public class Client {
    public static void main(String[] args) {
        AbstractClass h1 = new ConcreteClass1();
        AbstractClass h2 = new ConcreteClass2();
        //调用模板方法
        h1.templateMethod();
        h2.templateMethod();
    }
}
