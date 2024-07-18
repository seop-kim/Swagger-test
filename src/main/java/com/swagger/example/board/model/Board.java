package com.swagger.example.board.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Board {
    private Long id;
    private String title;
    private String content;

    public void addId(Long id) {
        this.id = id;
    }
}
