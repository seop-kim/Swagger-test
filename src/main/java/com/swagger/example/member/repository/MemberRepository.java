package com.swagger.example.member.repository;

import com.swagger.example.board.model.Board;
import com.swagger.example.member.model.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    private static final Map<Long, Member> members = new HashMap<>();
    private static Long id = 1L;

    public Long save(Member member) {
        member.addId(id);
        members.put(id, member);
        id++;
        return member.getId();
    }

    public Long update(Long id, Member member) {
        member.addId(id);
        members.put(id, member);
        return member.getId();
    }

    public Member findOne(Long id) {
        return members.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(members.values());
    }
}
