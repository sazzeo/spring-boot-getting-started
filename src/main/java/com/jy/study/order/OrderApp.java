package com.jy.study.order;

import com.jy.study.config.AppConfig;
import com.jy.study.member.Grade;
import com.jy.study.member.Member;
import com.jy.study.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService= appConfig.memberService();
        //OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService" , MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService" , OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId , "memberA" , Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId , "itemA", 20000);

        System.out.println(order);
        System.out.println(order.calculatePrice()); //할인후 가격 반환하기
    }


}
