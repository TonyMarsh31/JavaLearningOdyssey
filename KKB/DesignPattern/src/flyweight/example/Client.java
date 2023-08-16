package flyweight.example;

public class Client {
    public static final String[] departments = {"研发部", "销售部", "财务部", "人力资源部"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String department = departments[(int) (Math.random() * departments.length)];
            EmployeeFactory.getManagerByDepartment(department).report();
        }
    }
}
