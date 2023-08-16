package iterator.universal;

/**
 * 抽象容器
 */
public interface Aggregate {
    void add(Object obj);
    boolean remove(Object obj);
    Iterator iterator();
}
