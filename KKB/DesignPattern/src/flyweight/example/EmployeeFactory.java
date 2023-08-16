package flyweight.example;

import java.util.HashMap;
import java.util.Map;

public class EmployeeFactory {
    private static final Map<String, Employee> EMPLOYEE_MAP = new HashMap<>();

    public static Employee getManagerByDepartment(String department) {
        Manager manager = (Manager) EMPLOYEE_MAP.get(department);
        if (manager == null) {
            manager = new Manager(department);
            System.out.println("创建新的部门经理: " + department);
            String content = department + "部门的报告内容有……";
            manager.setReportContent(content);
            System.out.println("部门经理的报告内容: " + content);
            EMPLOYEE_MAP.put(department, manager);
        }
        return manager;
    }
}
