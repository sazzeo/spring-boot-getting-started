package com.jy.study;

import com.jy.study.member.Grade;
import com.jy.study.member.Member;
import com.jy.study.member.MemberService;
import com.jy.study.member.MemberServiceImpl;
import com.jy.study.order.Order;
import com.jy.study.order.OrderService;
import com.jy.study.order.OrderServiceImpl;
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
