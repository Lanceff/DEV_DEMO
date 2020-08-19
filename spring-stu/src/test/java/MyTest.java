import com.hui.MyAutowired;
import com.hui.UserController;
import com.hui.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @author: Lance
 * @Date: 2020-08-16 11:12
 * @Description:
 */
public class MyTest {

    @Test
    public void test1() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        UserService userService = new UserService();
        Field service = clazz.getDeclaredField("userService");
        service.setAccessible(true);
        String name = service.getName();
        Method method = clazz.getMethod("set" + name.substring(0, 1).toUpperCase() + name.substring(1), UserService.class);
        method.invoke(userController, userService);
        System.out.println(userController.getUserService());
    }

    @Test
    public void test2() {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        Stream.of(clazz.getDeclaredFields()).forEach(filed -> {
            MyAutowired annotation = filed.getAnnotation(MyAutowired.class);
            if (annotation != null) {
                try {
                    filed.setAccessible(true);
                    Object o = filed.getType().getDeclaredConstructor().newInstance();
                    filed.set(userController, o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(userController.getUserService());
    }

    @Test
    public void xmlParse() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    }
}
