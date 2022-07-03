package com.jy.study.sequrity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//스프링 시큐리티 기본 설정 등록
//얘를 등록하는 순간 스프링의 기본 시큐리티 설정은 동작안함
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/" , "hello").permitAll() // "/" 와 /hello는 인증 필요 없음
                .anyRequest().authenticated() //나머지는 인증 필요함
                .and()
                .formLogin()//form 로그인을 사용할거다
                .and()
                .httpBasic(); //httpBasic도 사용할것임.
    }



    //아무런 패스워드 인코딩도 하지 않을때 => 그냥 패스워드 쓸 때  절대 쓰면 안됨!!
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    //원래 메소드드
//   protected void configure(HttpSecurity http) throws Exception {
//        logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
//
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().and()
//                .httpBasic();
//    }
//


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }


}
