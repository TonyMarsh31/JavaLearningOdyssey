package iterator.intro;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //存放所有项目对象的集合
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("项目一", 10, 100));
        projects.add(new Project("项目二", 20, 200));
        projects.add(new Project("项目三", 30, 300));
        for (int i = 4; i < 100; i++) {
            projects.add(new Project("项目" + i, i, i * 100));
        }
        for (Project project : projects) {
            System.out.println(project.getProjectInfo());
        }
    }
}
