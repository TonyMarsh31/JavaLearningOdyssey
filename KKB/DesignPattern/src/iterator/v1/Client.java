package iterator.v1;

public class Client {
    public static void main(String[] args) {
        IProject project1 = new Project("项目", 1, 100);
        for (int i = 1; i < 100; i++) {
            project1.add(new Project("项目" + i, i, i * 100));
        }
        IProjectIterator iterator = project1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getProjectInfo());
        }
    }
}
