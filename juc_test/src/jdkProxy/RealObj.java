package jdkProxy;

/**
 * @author: Lance
 * @Date: 2020-10-19 17:53
 * @Description:
 */
public class RealObj implements Target{

    @Override
    public void msg() {
        System.out.println("realObj run...");
    }
}
