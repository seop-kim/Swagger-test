package com.swagger.example.member.dto;

import com.swagger.example.board.model.Board;
import com.swagger.example.member.model.Member;
import lombok.Builder;

public record AddMemberDto() {
    public record Request(
            String name) {}

    @Builder
    public record Response(Long id) {}

    public static Member toEntity(Request request) {
        return Member.builder()
                .name(request.name)
                .build();
    }

    public static Response of(Long id) {
        return Response.builder().id(id).build();
    }
}
