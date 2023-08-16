package version2.controller;

import version2.domain.Teacher;
import version2.service.TeacherService;

import java.util.Scanner;

public class TeacherController {

    private final Scanner sc = new Scanner(System.in);
    private final TeacherService teacherService = new TeacherService();

    public void start() {

        teacherLoop:
        while (true) {
            System.out.println("--------欢迎来到 <老师> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加老师  2.删除老师  3.修改老师  4.查看老师  5.退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    // System.out.println("添加老师");
                    addTeacher();
                    break;
                case "2":
                    // System.out.println("删除老师");
                    deleteTeacherById();
                    break;
                case "3":
                    // System.out.println("修改老师");
                    updateTeacher();
                    break;
                case "4":
                    // System.out.println("查看老师");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("感谢您使用老师管理系统, 再见!");
                    break teacherLoop;
                default:
                    System.out.println("您的输入有误, 请重新输入");
                    break;
            }
        }

    }

    public void updateTeacher() {
        String id = inputTeacherId();

        Teacher newTeacher = inputTeacherInfo(id);

        // 调用业务员的修改方法
        teacherService.updateTeacher(id,newTeacher);
        System.out.println("修改成功");
    }

    public void deleteTeacherById() {

        String id = inputTeacherId();

        // 2. 调用业务员中的删除方法, 根据id, 删除老师
        teacherService.deleteTeacherById(id);

        // 3. 提示删除成功
        System.out.println("删除成功");


    }

    public void findAllTeacher() {
        // 1. 从业务员中, 获取老师对象数组
        Teacher[] teachers = teacherService.findAllTeacher();

        // 2. 判断数组中是否有元素
        if (teachers == null) {
            System.out.println("查无信息, 请添加后重试");
            return;
        }

        // 3. 遍历数组, 取出元素, 并打印在控制台
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (Teacher t : teachers) {
            if (t != null) {
                System.out.println(t.getId() + "\t" + t.getName() + "\t" + t.getAge() + "\t\t" + t.getBirthday());
            }
        }
    }

    public void addTeacher() {
        String id;
        while (true) {
            // 1. 接收不存在的老师id
            System.out.println("请输入老师id:");
            id = sc.next();
            // 2. 判断id是否存在
            boolean exists = teacherService.isExists(id);

            if (exists) {
                System.out.println("id已被占用, 请重新输入:");
            } else {
                break;
            }
        }

        Teacher t = inputTeacherInfo(id);

        // 5. 将封装好的老师对象, 传递给TeacherService继续完成添加操作
        boolean result = teacherService.addTeacher(t);

        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    // 录入老师id
    public String inputTeacherId(){
        String id;
        while(true){
            System.out.println("请输入id");
            id = sc.next();
            boolean exists = teacherService.isExists(id);
            if(!exists){
                System.out.println("您输入的id不存在, 请重新输入:");
            }else{
                break;
            }
        }
        return id;
    }

    // 录入老师信息, 封装为老师对象
    public Teacher inputTeacherInfo(String id){
        System.out.println("请输入老师姓名:");
        String name = sc.next();
        System.out.println("请输入老师年龄:");
        String age = sc.next();
        System.out.println("请输入老师生日:");
        String birthday = sc.next();

        Teacher t = new Teacher();
        t.setId(id);
        t.setName(name);
        t.setAge(age);
        t.setBirthday(birthday);

        return t;
    }
}
