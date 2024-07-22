package com.swagger.example.member.model;

import com.swagger.example.board.model.Board;
import com.swagger.example.coupon.model.Coupon;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
    private Long id;
    private String name;

    @Builder.Default
    private List<Board> boards = new ArrayList<>();

    @Builder.Default
    private List<Coupon> coupons = new ArrayList<>();

    public void addId(Long id) {
        this.id = id;
    }
}
