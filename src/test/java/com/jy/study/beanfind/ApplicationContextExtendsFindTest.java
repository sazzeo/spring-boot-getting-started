package com.jy.study.beanfind;

import com.jy.study.discount.DiscountPolicy;
import com.jy.study.discount.FixDiscountPolicy;
import com.jy.study.discount.RateDiscountPolicy;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {


    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모타입으로 조회시, 자식이 둘 이상 있으면 중복 오류 발생")
    public void findBeanByParentTypeDuplicate() {
       // DiscountPolicy bean = ac.getBean(DiscountPolicy.class);

        //부모타입으로 조회시 자식까지 싹 다 조회됨.
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class ,
                () -> ac.getBean(DiscountPolicy.class));


    }

    @Test
    @DisplayName("부모타입으로 모두 조회")
    public void findAllBeanByParentType() {
        Map<String , Object> beans = ac.getBeansOfType(Object.class);

        for (String s : beans.keySet()) {

            System.out.println(beans.get(s));
        }

    }



    //내부 클래스로 빈 중복등록
    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDisCountPolicy()  {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }

    }
}
