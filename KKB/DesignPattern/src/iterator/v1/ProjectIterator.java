package iterator.v1;

import java.util.List;

public class ProjectIterator implements IProjectIterator {
    //存放所有项目对象的集合
    private List<IProject> projects;
    private Integer currentIndex = 0;

    public ProjectIterator(List<IProject> projects) {
        this.projects = projects;
    }

    /**
     * 判定是否还有下一个元素，必须要实现的方法
     *
     * @return true表示有下一个元素，false表示没有下一个元素
     */
    @Override
    public boolean hasNext() {
        if (currentIndex == null) return false;
        return currentIndex < projects.size();
    }

    @Override
    public IProject next() {
        return projects.get(currentIndex++);
    }

    /**
     * 根据实际情况判断是否要添加该方法的实现
     */
    public void remove(IProject project) {
        projects.remove(project);
    }
}
