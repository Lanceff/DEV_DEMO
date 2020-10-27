package base;

/**
 * @author: Lance
 * @Date: 2020-10-22 08:22
 * @Description:
 */
public class TryWithResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("��Դ�ر�");
    }

    public void print() {
        System.out.println("��ӡ��Դ");
    }

    public static void main(String[] args) {
        try (TryWithResource resource = new TryWithResource()) {
            System.out.println("��ͨҵ���߼�");
            resource.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
