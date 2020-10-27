package com.hui.tx;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;

/**
 * @author: Lance
 * @Date: 2020-10-20 14:59
 * @Description:
 */
@Configuration
@EnableTransactionManagement
public class TxConfig {


    public static void main(String[] args) {
        HashMap hashMap = new HashMap(20);
        hashMap.put("a", 10);


        String s1 = String.valueOf(1);
        String s2 = String.valueOf(1.0f);
        String s3 = String.valueOf((char) 1);

        Integer i1 = Integer.valueOf(1);
        Integer i2 = Integer.valueOf("3");
        Float f1 = Float.valueOf(3.2f);
        Float f2 = Float.valueOf("3.2f");
        Double d1 = Double.valueOf(2.3);
        Double d2 = Double.valueOf("2.3d");


        int ii1 = Integer.parseInt("1");
        double dd1 = Double.parseDouble("3.2");
        float ff1 = Float.parseFloat("2.2f");

        i1.intValue();
        i1.byteValue();
        i1.doubleValue();
        double v1 = d1.doubleValue();

        s1.isEmpty();
        s1.isBlank();
        s1.substring(2);
        s1.replace("","");
    }
}
