package com.hui;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @author: Lance
 * @Date: 2020-08-27 09:48
 * @Description: @Import 注册selectImports中返回的类
 */
public class MyImportSelector implements ImportSelector {
    /**
     * AnnotationMetadata:当前标注@Import注解的类的所有注解信息
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //方法不要返回null值
        return new String[]{"com.hui.user.SelectOne", "com.hui.user.SelectTwo"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
