package com.jy.study.beanfind;


import com.jy.study.AppConfig;
import com.jy.study.member.MemberRepository;
import com.jy.study.member.MemberService;
import com.jy.study.member.MemberServiceImpl;
import com.jy.study.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//빈 찾는
public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName() {
        MemberService memberService = ac.getBean("memberService" , MemberService.class);
        System.out.println(memberService);
        System.out.println(memberService.getClass()); //어떤 구현 객체인지 확인하기  MemberServiceImpl


        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }



    @Test
    @DisplayName("이름 없이 타입으로 조회")
    public void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);  //매개변수로 Class만 받음


        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }


    @Test
    @DisplayName("구체 타입으로 조회")
    public void findBeanByType2() {
        MemberService memberService = ac.getBean(MemberServiceImpl.class);  //구현객체인 Impl로 테스트

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("구체 타입으로 조회")
    public void findBeanByNameX() {
        //xxxx란 이름의 빈은 없음
        //예외 잡는법
        //NoSuchBeanDefinitionExceiption
        assertThrows(NoSuchBeanDefinitionException.class , ()-> ac.getBean("xxxx" , MemberService.class));

    }

}
