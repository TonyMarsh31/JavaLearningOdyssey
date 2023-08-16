package iterator.universal;

/**
 * 抽象迭代器
 */
public interface Iterator {
    //遍历到下一个元素
    Object next();
    //是否已经遍历到最后
    boolean hasNext();
    //获取第一个元素
    Object first();
    //删除指定元素
    boolean remove(Object obj);
}
