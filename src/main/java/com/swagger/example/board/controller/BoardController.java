package com.swagger.example.board.controller;

import com.swagger.example.board.dto.AddBoardDto;
import com.swagger.example.board.dto.FindBoardDto;
import com.swagger.example.board.dto.ModBoardDto;
import com.swagger.example.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Board-API", description = "게시판 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService service;

    @Operation(summary = "ID 게시글 조회")
    @GetMapping("/{id}")
    public ResponseEntity<FindBoardDto.Response> findBoard(@PathVariable Long id) {
        FindBoardDto.Response response = service.findOne(id);
        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "전체 게시글 조회", responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = FindBoardDto.Response.class)))})
    @GetMapping
    public ResponseEntity<List<FindBoardDto.Response>> findAllBoard() {
        List<FindBoardDto.Response> response = service.findAll();
        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "게시글 작성", responses = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = AddBoardDto.Response.class)))})
    @PostMapping
    public ResponseEntity<AddBoardDto.Response> addBoard(@RequestBody AddBoardDto.Request request) {
        AddBoardDto.Response response = service.addBoard(request);
        return ResponseEntity.created(null).body(response);
    }

    @Operation(summary = "게시글 수정", responses = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = AddBoardDto.Response.class)))})
    @PutMapping("/{id}")
    public ResponseEntity<?> modBoard(@PathVariable Long id,
                                      @RequestBody ModBoardDto.Request request) {
        ModBoardDto.Response response = service.modBoard(id, request);
        return ResponseEntity.ok().body(response);
    }

}
