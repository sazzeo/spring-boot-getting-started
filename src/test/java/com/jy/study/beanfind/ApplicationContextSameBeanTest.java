package com.jy.study.beanfind;

import com.jy.study.AppConfig;
import com.jy.study.member.MemberRepository;
import com.jy.study.member.MemoryMemberRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameBeanTest {


    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);


    @Test
    @DisplayName("빈 타입이 2개있는 경우")
    public void findBeanByTypeDuplicate() {

        //   MemberRepository bean = ac.getBean(MemberRepository.class); //NoUniqueBeanDefinitionException

        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class));


    }


    @Test
    @DisplayName("타입으로 조회시 같은 타입이 두개 이상 있으면 빈 이름으로 찾기")
    public void findBeanByName() {

        MemberRepository bean = ac.getBean("memberRepository1" , MemberRepository.class);
        assertThat(bean).isInstanceOf(MemoryMemberRepository.class);

    }
      @Test
    @DisplayName("특정 타입을 모두 조회하기")
    public void findBeansByType() {

        Map<String, MemberRepository> bean = ac.getBeansOfType(MemberRepository.class);
          for (String s : bean.keySet()) {
              System.out.println(bean.get(s));
          }
            
        assertThat(bean.size()).isEqualTo(2);
    }




    //내부 클래스로 빈 중복등록
    @Configuration
    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }

    }
}
