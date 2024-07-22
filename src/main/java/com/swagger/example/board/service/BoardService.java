package com.swagger.example.board.service;

import com.swagger.example.board.dto.AddBoardDto;
import com.swagger.example.board.dto.FindBoardDto;
import com.swagger.example.board.dto.FindBoardDto.Response;
import com.swagger.example.board.dto.ModBoardDto;
import com.swagger.example.board.model.Board;
import com.swagger.example.board.repository.BoardRepository;
import com.swagger.example.coupon.model.Coupon;
import com.swagger.example.coupon.repository.CouponRepository;
import com.swagger.example.member.model.Member;
import com.swagger.example.member.repository.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final CouponRepository couponRepository;

    public List<FindBoardDto.Response> findAll() {
        List<Board> findAll = boardRepository.findAll();
        List<Response> responses = new ArrayList<>();

        for (Board board : findAll) {
            Member findMember = memberRepository.findOne(board.getId());
            responses.add(FindBoardDto.of(board, findMember));
        }

        return responses;
    }

    public FindBoardDto.Response findOne(Long id) {
        Board findOne = boardRepository.findOne(id);
        Member findMember = memberRepository.findOne(findOne.getMember().getId());
        return FindBoardDto.of(findOne, findMember);
    }

    public AddBoardDto.Response addBoard(AddBoardDto.Request request) {
        Board board = AddBoardDto.toEntity(request);
        boardRepository.save(board);

        Member findMember = memberRepository.findOne(request.memberId());
        board.addMember(findMember);

        Coupon coupon = Coupon.builder().name("글 작성 할인 쿠폰").member(findMember).build();
        coupon.addMember(findMember);
        couponRepository.save(coupon);

        return AddBoardDto.of(board.getId());
    }

    public ModBoardDto.Response modBoard(Long id, ModBoardDto.Request request) {
        searchValidate(id);
        Board board = ModBoardDto.toEntity(request);
        return ModBoardDto.of(boardRepository.update(id, board));
    }


    private void searchValidate(Long id) {
        if (boardRepository.findOne(id) == null) {
            throw new IllegalArgumentException("no content");
        }
    }
}
