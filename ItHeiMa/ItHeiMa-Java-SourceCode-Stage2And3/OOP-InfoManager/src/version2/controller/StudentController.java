package version2.controller;

import version2.domain.Student;

import java.util.Scanner;

public class StudentController extends BaseStudentController {

    private final Scanner sc = new Scanner(System.in);

    // 键盘录入学生信息
    // 开闭原则: 对扩展内容开放, 对修改内容关闭
    @Override
    public Student inputStudentInfo(String id) {
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        String age = sc.next();
        System.out.println("请输入学生生日:");
        String birthday = sc.next();
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return stu;
    }
}
