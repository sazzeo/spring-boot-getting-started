package com.jy.study.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{


    //데이터를 저장할 저장소 : 개인 메모리에 저장
    private static Map<Long, Member> store = new HashMap<>();


    @Override
    public void save(Member member) {

        store.put(member.getId() , member);

    }

    @Override
    public Member findById(Long memberId) {

        return store.get(memberId);
    }
}
