package com.jy.study.beandefinition;

import com.jy.study.config.AppConfig;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    GenericXmlApplicationContext ac2 = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    public void findApplicationBean() {

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition defition = ac.getBeanDefinition(beanDefinitionName);
            System.out.println(defition);

        }
    }

    @Test
    @DisplayName("빈 설정 메타정보 확인 (xml) ")
    public void findApplicationBean2() {

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition defition = ac.getBeanDefinition(beanDefinitionName);
            System.out.println(defition);

        }
    }


}
