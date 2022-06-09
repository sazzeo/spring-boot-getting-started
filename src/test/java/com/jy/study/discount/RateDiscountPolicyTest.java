package com.jy.study.discount;

import com.jy.study.member.Grade;
import com.jy.study.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    public void vip_o() {
        //given
        Member member = new Member(1L , "memberVip" , Grade.VIP);
        int discount = discountPolicy.discount(member , 10000);
        Assertions.assertThat(discount).isEqualTo(1000);


    }


    @Test
    @DisplayName("VIP가 아닌 경우 할인이 적용되면 안된다")
    public void vip_x() {
        //given
        Member member = new Member(1L , "memberBasic" , Grade.BASIC);
        int discount = discountPolicy.discount(member , 10000);
        Assertions.assertThat(discount).isEqualTo(1000);


    }


}