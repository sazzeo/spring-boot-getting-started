package com.jy.study.member;

import com.jy.study.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class MemberServiceTest {

    MemberService memberService ;

    @BeforeEach //테스트 개수만큼 도는 코드
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();

    }
    @Test
    public void join() {
        //given
        Member member = new Member(1L , "memberA" , Grade.BASIC);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);  //검증 클래스 Assertions

    }


}
