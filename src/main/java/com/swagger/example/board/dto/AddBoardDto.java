package com.swagger.example.board.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swagger.example.board.model.Board;
import com.swagger.example.member.model.Member;
import lombok.Builder;

public record AddBoardDto() {
    public record Request(
            String title,
            String content,
            Long memberId) {}

    @Builder
    public record Response(Long id) {}


    public static Board toEntity(AddBoardDto.Request request) {
        return Board.builder()
                .title(request.title)
                .content(request.content)
                .build();
    }

    public static Response of(Long id) {
        return Response.builder().id(id).build();
    }
}
