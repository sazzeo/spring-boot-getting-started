package com.jy.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Application class는 최상위 패키지 바로 아래 만든다
//이유 : 이 밑에 있는 패키지부터 component scan하기 때문임
@SpringBootApplication  //이 어노테이션 살펴보기
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }
}
