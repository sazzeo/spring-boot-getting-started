package com.jy.study.config;

import com.jy.study.aop.TimeTraceAop;
import com.jy.study.discount.DiscountPolicy;
import com.jy.study.discount.FixDiscountPolicy;
import com.jy.study.discount.RateDiscountPolicy;
import com.jy.study.member.MemberService;
import com.jy.study.member.MemberServiceImpl;
import com.jy.study.member.MemoryMemberRepository;
import com.jy.study.order.OrderService;
import com.jy.study.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //스프링 컨테이너에 등록
public class AppConfig {


    //이렇게 등록한 빈들은 객체 생성과 관계 연결이 한번에 일어나게 된다.
    //컴포넌트 스캔을 사용하게 되면 빈을 먼저 만들고 연결관계를 연결한다.
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


    //aop 빈으로 등록: @Component 안쓰는 이유 => 명시적으로 쓰려고
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }


}
