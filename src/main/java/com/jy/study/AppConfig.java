package com.jy.study;

import com.jy.study.discount.DiscountPolicy;
import com.jy.study.discount.FixDiscountPolicy;
import com.jy.study.discount.RateDiscountPolicy;
import com.jy.study.member.MemberService;
import com.jy.study.member.MemberServiceImpl;
import com.jy.study.member.MemoryMemberRepository;
import com.jy.study.order.OrderService;
import com.jy.study.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }


    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository() , getDiscountPolicy());
    }

    //굳이 getter만드는 이유: 겹치는 코드 수정시 한번만 수정하기 위해서
    private MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }
    private DiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }


    
}
