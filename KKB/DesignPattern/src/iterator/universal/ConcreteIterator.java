package iterator.universal;

import java.util.List;

/**
 * 具体迭代器
 */
public class ConcreteIterator implements Iterator {
    //也可以选择使用Vector
    private List<Object> list;
    //定义当前位置
    private int index = 0;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    public boolean hasNext() {
        return index != list.size();
    }

    public Object first() {
        index = 0;
        return list.get(index);
    }

    public Object next() {
        return list.get(index++);
    }

    public boolean remove(Object obj) {
        return this.list.remove(obj);
    }
}
