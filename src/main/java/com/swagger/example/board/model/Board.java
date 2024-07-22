package com.swagger.example.board.model;

import com.swagger.example.member.model.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Board {
    private Long id;
    private Member member;
    private String title;
    private String content;

    public void addId(Long id) {
        this.id = id;
    }

    public void addMember(Member member) {
        this.member = member;
        member.getBoards().add(this);
    }
}
