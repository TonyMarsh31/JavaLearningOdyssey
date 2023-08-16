package iterator.intro;

public class Project implements IProject {
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
}
