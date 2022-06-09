package com.jy.study;

import com.jy.study.member.Grade;
import com.jy.study.member.Member;
import com.jy.study.member.MemberService;
import com.jy.study.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();  //AppConfig에서 알아서 객체 생성해줌.


        //스프링에서 객체 생성된 애들 다 넣어줌.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService" , MemberService.class);


        Member member = new Member(1L , "memberA" , Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());


    }


}
