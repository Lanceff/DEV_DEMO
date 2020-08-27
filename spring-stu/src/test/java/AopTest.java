import com.hui.aop.AopConfig;
import com.hui.aop.MyService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Lance
 * @Date: 2020-08-27 18:44
 * @Description:
 */
public class AopTest {

    @Test
    public void aoptest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        MyService myService = context.getBean(MyService.class);
        int divide = myService.divide(1, 0);
        context.close();
    }
}
