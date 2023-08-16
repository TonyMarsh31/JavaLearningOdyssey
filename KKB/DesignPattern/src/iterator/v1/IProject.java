package iterator.v1;

public interface IProject {
    /**
     * Boss通过这里查看项目信息
     */
    String getProjectInfo();

    /**
     * 添加项目
     *
     * @param project 项目
     */
    void add(IProject project);

    /**
     * 获取一个可遍历的对象
     */
    IProjectIterator iterator();

}
