package com.swagger.example.board.dto;

import com.swagger.example.board.model.Board;
import lombok.Builder;

public record AddBoardDto() {
    public record Request(
            String title,
            String content) {}

    @Builder
    public record Response(Long id) {}

    public static Board toEntity(AddBoardDto.Request request) {
        return Board.builder()
                .title(request.title)
                .content(request.content)
                .build();
    }

    public static AddBoardDto.Response of(Long id) {
        return Response.builder().id(id).build();
    }
}
