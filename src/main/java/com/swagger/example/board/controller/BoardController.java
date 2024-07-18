package com.swagger.example.board.controller;

import com.swagger.example.board.dto.AddBoardDto;
import com.swagger.example.board.dto.FindBoardDto;
import com.swagger.example.board.dto.FindBoardDto.Response;
import com.swagger.example.board.service.BoardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Board-API", description = "게시판 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService service;

    @GetMapping("/{id}")
    public ResponseEntity<FindBoardDto.Response> findBoard(@PathVariable Long id) {
        FindBoardDto.Response response = service.findOne(id);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping
    public ResponseEntity<List<FindBoardDto.Response>> findAllBoard() {
        List<FindBoardDto.Response> response = service.findAll();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<AddBoardDto.Response> addBoard(AddBoardDto.Request request) {
        AddBoardDto.Response response = service.addBoard(request);
        return ResponseEntity.created(null).body(response);
    }
}
