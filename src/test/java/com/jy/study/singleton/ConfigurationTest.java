package com.jy.study.singleton;

import com.jy.study.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationTest {

    @Test
    public void configurationDeep() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println(bean.getClass());

        //AppConfig$$EnhancerBySpringCGLIB$$67c269f0 가 등록됨.

    }
}
