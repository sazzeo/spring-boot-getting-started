package com.jy.study.sequrity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //스프링 시큐리티 의존성을 추가하게 되면 모든 요청에 대해 인증 절차가 걸리게 된다.
    // localhost:8080으로 접속하면 자동으로 /login으로 redirect됨.
    // 이때 로그인 페이지는 스프링이 자동으로 만들어줌줌
    // 아이디는 user , 패스워드는 서버 올릴때 나옴


    //스프링 시큐리티 설정 파일 :
    // 1. SecurityAutoConfiguration  : EventPublisher  => 어디 입장 등등을 할 때 이벤트를 발생 시킴
    // 2. WebSecurityConfiguration : 기본 web설정이 담겨있고, 상속받아서 오버라이딩함.
    // 3. UserDetailsServiceAutoConfiguration => 스프링 애플리케이션이 뜰 때 user객체를 만들어주는 애
    // @ConditinalOnMissingBean의 의미: 따로 설정이 없을때는 그 설정 파일이 적용됨,
    // 사용자가 만들면 적용 안됨.


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/my")
    public String my() {
        return "my";
    }

}