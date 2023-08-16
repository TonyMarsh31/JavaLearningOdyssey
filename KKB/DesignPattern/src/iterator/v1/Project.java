package iterator.v1;

import java.util.ArrayList;
import java.util.List;

public class Project implements IProject {

    //存放所有项目对象的集合
    private List<IProject> projects = new ArrayList<>();
    private String name;
    private Integer num;
    private Integer cost;

    public Project(String name, Integer num, Integer cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    /**
     * Boss通过这里查看项目信息
     */
    @Override
    public String getProjectInfo() {
        return "项目名称：" + name + "\t项目人数 ：" + num + "\t项目费用：" + cost;
    }

    /**
     * 添加项目
     *
     * @param project 项目
     */
    @Override
    public void add(IProject project) {
        this.projects.add(project);
    }

    /**
     * 获取一个可遍历的对象
     */
    @Override
    public IProjectIterator iterator() {
        return new ProjectIterator(this.projects);
    }
}
