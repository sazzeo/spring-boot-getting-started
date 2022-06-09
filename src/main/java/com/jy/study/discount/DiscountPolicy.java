package com.jy.study.discount;

import com.jy.study.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
