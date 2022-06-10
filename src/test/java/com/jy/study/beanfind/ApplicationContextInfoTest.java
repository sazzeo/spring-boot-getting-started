package com.jy.study.beanfind;

import com.jy.study.AppConfig;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기") //쓸데없는 빈까지 다 출력됨
    public void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter tab으로 바로 자동완성 가능
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " // object = " + bean);

        }

    }


    @Test
    @DisplayName("내 빈만 출력하기")
    public void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        //iter tab으로 바로 자동완성 가능
        for (String beanDefinitionName : beanDefinitionNames) {

            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //BeanDefinition.ROLE_APPLICATION : 직접 등록한빈
            //BeanDefinition.ROLE_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {

                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " // object = " + bean);

            }

        }

    }

}
