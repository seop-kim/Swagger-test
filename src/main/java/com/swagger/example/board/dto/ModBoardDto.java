package com.swagger.example.board.dto;

import com.swagger.example.board.dto.AddBoardDto.Response;
import com.swagger.example.board.model.Board;
import lombok.Builder;

public record ModBoardDto() {
    public record Request(
            String modTitle,
            String modContent
    ) {}

    @Builder
    public record Response(Long id) {}

    public static Board toEntity(ModBoardDto.Request request) {
        return Board.builder()
                .title(request.modTitle)
                .content(request.modContent)
                .build();
    }

    public static Response of(Long id) {
        return Response.builder().id(id).build();
    }
}
