package Record;

public class RecordTest {
    public static void main(String[] args) {
        pojoRecord test = new pojoRecord("John", 42);

        System.out.println(test.age());
        System.out.println(test.name());

        System.out.println(test);
    }
}
