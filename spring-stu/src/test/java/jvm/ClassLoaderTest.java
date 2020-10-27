package jvm;

/**
 * @author: Lance
 * @Date: 2020-09-11 11:40
 * @Description:
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoaderTest.class.getClassLoader().loadClass("com.hui.user.Dog");
    }

}
