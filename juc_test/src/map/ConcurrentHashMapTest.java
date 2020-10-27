package map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Lance
 * @Date: 2020-10-15 16:05
 * @Description:
 */
public class ConcurrentHashMapTest {

    public static void test() {

    }
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap(); //初始化ConcurrentHashMap
        //新增个人信息
        map.put("id", "1");
        map.put("name", "andy");
        map.put("sex", "男");
        //获取姓名
        String name = map.get("name");
        //计算大小
        int size = map.size();
    }
}
