package iterator.universal;

import java.util.ArrayList;

/**
 * 具体容器
 */
public class ConcreteAggregate implements Aggregate {
    //也可以使用Vector
    private ArrayList<Object> list = new ArrayList<>();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public boolean remove(Object obj) {
        return list.remove(obj);
    }

    @Override
    public Iterator iterator() {
        return (new ConcreteIterator(list));
    }
}
