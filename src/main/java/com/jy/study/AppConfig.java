package com.jy.study;

import com.jy.study.discount.FixDiscountPolicy;
import com.jy.study.member.MemberService;
import com.jy.study.member.MemberServiceImpl;
import com.jy.study.member.MemoryMemberRepository;
import com.jy.study.order.OrderService;
import com.jy.study.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository() , new FixDiscountPolicy());
    }
}
