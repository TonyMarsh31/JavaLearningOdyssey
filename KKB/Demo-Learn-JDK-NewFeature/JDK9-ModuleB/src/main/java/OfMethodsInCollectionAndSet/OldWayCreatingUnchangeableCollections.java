package OfMethodsInCollectionAndSet;

import java.util.*;

public class OldWayCreatingUnchangeableCollections {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set = Collections.unmodifiableSet(set);//实现返回不可修改的集合
        System.out.println(set);

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list = Collections.unmodifiableList(list);//实现返回不可修改的集合
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("A", "Apple");
        map.put("B", "Boy");
        map.put("C", "Cat");
        map = Collections.unmodifiableMap(map);
        System.out.println(map);
    }
}
