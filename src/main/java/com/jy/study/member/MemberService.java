package com.jy.study.member;

public interface MemberService {

    void join(Member member); //회원가입

    Member findMember(Long memberId); //회원 조회

}
