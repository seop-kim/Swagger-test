package com.swagger.example.board.repository;

import com.swagger.example.board.model.Board;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository {
    private static final Map<Long, Board> boards = new HashMap<>();
    private static Long id = 1L;

    public Long save(Board board) {
        board.addId(id);
        boards.put(id, board);
        id++;
        return board.getId();
    }

    public Board findOne(Long id) {
        return boards.get(id);
    }

    public List<Board> findAll() {
        return new ArrayList<>(boards.values());
    }
}
