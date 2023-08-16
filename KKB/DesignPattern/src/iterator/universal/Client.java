package iterator.universal;

public class
Client {
    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate();
        ag.add("赵丽颖");
        ag.add("宋慧乔");
        ag.add("王菲");
        System.out.print("遍历容器中的内容如下：\n");
        Iterator it = ag.iterator();
        while (it.hasNext()) {
            Object ob = it.next();
            System.out.print(ob.toString() + "\n");
        }
        Object ob = it.first();
        System.out.println("\nFirst：" + ob.toString());
    }
}
