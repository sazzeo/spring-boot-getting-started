package com.jy.study.xml;

import com.jy.study.member.MemberService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlContext {

    @Test
    public void xmlAppContext() {

        //classpath : resources
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        MemberService memberService = ac.getBean(MemberService.class);


    }
}
