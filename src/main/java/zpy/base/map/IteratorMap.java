package zpy.base.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 四种遍历Map集合的方式
 *
 * @author zpy
 */
@SuppressWarnings("all")
public class IteratorMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("aaa", "aaa");
        map.put("bbb", "bbb");
        map.put("ccc", "ccc");
        map.put("ddd", "ddd");
        map.put("eee", "eee");

        /*
         * 1、常规方式使用keySet()方法遍历
         */
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
        System.out.println("----------");
        /*
         * 2、使用entrySet()遍历key和value
         */
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("----------");
        /*
         * 3、entrySet()使用Iterator遍历key和value
         */
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while ((iterator.hasNext())) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("----------");
        /*
         * 4、遍历所有的value
         */
        System.out.println(map.values());
    }
}
