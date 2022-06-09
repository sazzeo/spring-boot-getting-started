package com.jy.study.order;

import com.jy.study.discount.DiscountPolicy;
import com.jy.study.discount.FixDiscountPolicy;
import com.jy.study.discount.RateDiscountPolicy;
import com.jy.study.member.Member;
import com.jy.study.member.MemberRepository;
import com.jy.study.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member , itemPrice); //할인의 대한 책임은 discount에 있음 => 단일책임 원칙
        Order order = new Order(memberId , itemName , itemPrice , discountPrice);

        return order;
    }
}
