package base;

/**
 * @author: Lance
 * @Date: 2020-10-22 08:22
 * @Description:
 */
public class TryWithResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("资源关闭");
    }

    public void print() {
        System.out.println("打印资源");
    }

    public static void main(String[] args) {
        try (TryWithResource resource = new TryWithResource()) {
            System.out.println("普通业务逻辑");
            resource.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
