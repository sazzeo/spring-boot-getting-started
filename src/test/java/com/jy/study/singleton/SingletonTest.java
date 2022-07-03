package com.jy.study.singleton;

import com.jy.study.config.AppConfig;
import com.jy.study.member.MemberService;
import com.jy.study.member.MemberServiceImpl;
import com.jy.study.order.OrderServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {



    @Test
    @DisplayName("싱글톤 객체 일치확인하기")
    public void singletonTest() {
        SingletonService s1 = SingletonService.getInstance();
        SingletonService s2 = SingletonService.getInstance();

        
        //==비교
        assertThat(s1).isSameAs(s2);

    }

    @Test
    @DisplayName("스프링 컨테이너 싱글톤")
    public void springContainer() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService" , MemberService.class);
        MemberService memberService2 = ac.getBean("memberService" , MemberService.class);


        //스프링 컨테이너로 뽑은 빈은 같은 객체를 공유함.
        assertThat(memberService1).isSameAs(memberService2);

    }


    @Test
    @DisplayName("@Configuration @Bean 싱글톤 확인")
    public void springContainer2() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService" , MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService" , OrderServiceImpl.class);


        //Bean에서 new로 memberRepository를 생성함에도 같은 객체를 공유하는 싱글톤 패턴으로 생성된 것을 알 수 있음.
        assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());

    }

}
