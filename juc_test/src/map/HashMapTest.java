package map;

import java.util.HashMap;

/**
 * @author: Lance
 * @Date: 2020-10-13 16:46
 * @Description:
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(15);
        for (int i = 0; i < 20; i++) {
            map.put("key" + i, "v" + i);
        }

        map.get("");
        map.size();
    }
}
