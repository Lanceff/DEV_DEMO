package com.hui.aware;

import com.hui.user.Color;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.util.StringValueResolver;

import java.util.Arrays;


/**
 * @author: Lance
 * @Date: 2020-08-27 15:37
 * @Description: 1.-Dspring.profiles.active=test
 */
@ComponentScan("com.hui.aware")
@Configurable
@PropertySource(value = "classpath:pfile.properties")
public class AwareConfig implements EmbeddedValueResolverAware {

    @Value("AwareConfig")
    public String myclass;
    @Value("${static.password}")
    public String password;

    private String num;
    private StringValueResolver stringValueResolver;


    @Bean("profileTest")
    @Profile("test")
    public MyContent profileTest(@Value("${static.user}") String user) {
        MyContent map = new MyContent();
        map.put("user", user);
        map.put("password", password);
        map.put("profile", "test");
        map.put("num", num);
        return map;
    }

    @Bean("profileDev")
    @Profile("dev")
    public MyContent profileDev(@Value("${static.user}") String user) {
        MyContent map = new MyContent();
        map.put("user", user);
        map.put("password", password);
        map.put("profile", "dev");
        map.put("num", num);
        return map;
    }

    @Bean("profileProd")
    @Profile("prod")
    public MyContent profileProd(@Value("${static.user}") String user) {
        MyContent map = new MyContent();
        map.put("user", user);
        map.put("password", password);
        map.put("profile", "prod");
        map.put("num", num);
        return map;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.stringValueResolver = stringValueResolver;
        this.num = stringValueResolver.resolveStringValue("${num}");
    }

    @Bean
    public Color color() {
        return new Color();
    }

}
