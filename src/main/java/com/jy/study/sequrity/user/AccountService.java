package com.jy.study.sequrity.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


//UserDetailService : => 어떤걸로 인증할지 등록하는 빈
// @Service 를 이용해 빈으로 등록하면 이제 스프링 올릴떄 기본 password 안올라옴
@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    //=> 인코딩한 패스워드를 디비에 저장시킬것.
    //    passwordEncoder.encode("패스워드");

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        //new User로 아이디와 패스워드 등록함
        //password encoder를 등록안하면 안됨

        return null;

    }
    
    
}
