package com.swagger.example.board.service;

import com.swagger.example.board.dto.AddBoardDto;
import com.swagger.example.board.dto.FindBoardDto;
import com.swagger.example.board.model.Board;
import com.swagger.example.board.repository.BoardRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository repo;

    public List<FindBoardDto.Response> findAll() {
        List<Board> findAll = repo.findAll();
        List<FindBoardDto.Response> responses = new ArrayList<>();

        for (Board board : findAll) {
            responses.add(FindBoardDto.of(board));
        }

        return responses;
    }

    public FindBoardDto.Response findOne(Long id) {
        Board findOne = repo.findOne(id);
        return FindBoardDto.of(findOne);
    }

    public AddBoardDto.Response addBoard(AddBoardDto.Request request) {
        Board board = AddBoardDto.toEntity(request);
        return AddBoardDto.of(repo.save(board));
    }
}
