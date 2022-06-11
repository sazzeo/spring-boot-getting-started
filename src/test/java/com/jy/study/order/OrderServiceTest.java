package com.jy.study.order;

import com.jy.study.AppConfig;
import com.jy.study.member.Grade;
import com.jy.study.member.Member;
import com.jy.study.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class OrderServiceTest {


    MemberService memberService ;
    OrderService orderService ;

    @Before
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    public void createOrder() {

        Long memberId = 1L;
        Member member = new Member(memberId , "memberA" , Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId , "itemA", 10000);


        //Assertions 확인
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
