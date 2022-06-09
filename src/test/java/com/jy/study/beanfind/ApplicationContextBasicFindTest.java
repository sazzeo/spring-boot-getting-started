package com.jy.study.beanfind;


import com.jy.study.AppConfig;
import com.jy.study.member.MemberService;
import com.jy.study.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import org.junit.jupiter.api.DisplayName;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//빈 찾는
public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName() {
        MemberService memberService = ac.getBean("memberService" , MemberService.class);
        System.out.println(memberService);
        System.out.println(memberService.getClass()); //어떤 구현 객체인지 확인하기  MemberServiceImpl


        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);




    }
}
