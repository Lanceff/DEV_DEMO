import com.hui.AppConfig;
import com.hui.aware.AwareConfig;
import com.hui.aware.MyContent;
import com.hui.my.MyAutowired;
import com.hui.my.UserController;
import com.hui.my.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

    /**
     * 使用反射进行注入
     *
     * @throws Exception
     */
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

    /**
     * 使用注解的方式自动注入
     */
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
        UserController bean = context.getBean(UserController.class);
        System.out.println(bean);
    }


    @Test
    public void AnnotationConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("============");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("============");
        /*Object color1 = context.getBean("color");
        Object color2 = context.getBean("color");
        System.out.println(color1 == color2);*/

       /* Object cat1 = context.getBean("cat");
        Object cat2 = context.getBean("cat");
        context.getBean("cat");
        System.out.println(cat1==cat2);*/

        Object fbean1 = context.getBean("myFactoryBean");
        Object fbean2 = context.getBean("&myFactoryBean");
        System.out.println(fbean1.getClass());
        System.out.println(fbean2.getClass());
    }

    @Test
    public void lifeCycleConfig() {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        System.out.println(context);
        String[] namesForType = context.getBeanNamesForType(MyContent.class);
        for (String string : namesForType) {
            System.out.println(string);
            System.out.println(context.getBean(string).toString());
        }

        context.close();
    }

    @Test
    public void profileTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(AwareConfig.class);
        context.refresh();
        String[] namesForType = context.getBeanNamesForType(MyContent.class);
        for (String string : namesForType) {
            System.out.println(context.getBean(string).toString());
        }
        System.out.println(context.getBean("color"));
        context.close();
    }
}

