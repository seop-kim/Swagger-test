package com.swagger.example.board.dto;

import com.swagger.example.board.model.Board;
import lombok.Builder;

public record FindBoardDto() {
    @Builder
    public record Response(
            Long id,
            String title,
            String content
    ) {}

    public static Response of(Board board) {
        return Response.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }
}
