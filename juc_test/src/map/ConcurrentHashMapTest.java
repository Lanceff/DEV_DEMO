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
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap(); //��ʼ��ConcurrentHashMap
        //����������Ϣ
        map.put("id", "1");
        map.put("name", "andy");
        map.put("sex", "��");
        //��ȡ����
        String name = map.get("name");
        //�����С
        int size = map.size();
    }
}
