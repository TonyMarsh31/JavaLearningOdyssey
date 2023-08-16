package version2.dao;

import version2.domain.Student;

public interface BaseStudentDao {
    // 添加学生方法
    boolean addStudent(Student stu);
    // 查看学生方法
    Student[] findAllStudent();
    // 删除学生方法
    void deleteStudentById(String delId);
    // 根据id找索引方法
    int getIndex(String id);
    // 修改学生方法
    void updateStudent(String updateId, Student newStu);
}
