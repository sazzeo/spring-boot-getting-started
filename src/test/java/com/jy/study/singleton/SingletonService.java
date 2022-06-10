package com.jy.study.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    
    //인스턴스 조회
    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private으로 선언하면 외부에서 new 생성자를 쓸 수 없어짐.
    private SingletonService() {

    }
    

}
