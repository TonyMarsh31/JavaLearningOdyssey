package version2.dao;

import version2.domain.Student;

import java.util.ArrayList;

public class OtherStudentDao implements BaseStudentDao {
    // 集合容器
    private static final ArrayList<Student> students = new ArrayList<>();

    static {
        Student stu1 = new Student("heima001","张三","23","1999-11-11");
        Student stu2 = new Student("heima002","李四","24","2000-11-11");

        students.add(stu1);
        students.add(stu2);
    }

    // 添加学生方法
    public boolean addStudent(Student stu) {
       students.add(stu);
       return true;
    }

    // 查看学生方法
    public Student[] findAllStudent() {

        Student[] students = new Student[OtherStudentDao.students.size()];

        for (int i = 0; i < students.length; i++) {
            students[i] = OtherStudentDao.students.get(i);
        }

        return students;
    }

    public void deleteStudentById(String delId) {
        // 1. 查找id在容器中所在的索引位置
        int index = getIndex(delId);
        students.remove(index);
    }

    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            Student stu = students.get(i);
            if(stu != null && stu.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateStudent(String updateId, Student newStu) {
        // 1. 查找updateId, 在容器中的索引位置
        int index = getIndex(updateId);
        students.set(index, newStu);
    }
}
