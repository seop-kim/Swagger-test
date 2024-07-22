package com.swagger.example.board.dto;

import com.swagger.example.board.model.Board;
import com.swagger.example.coupon.model.Coupon;
import com.swagger.example.member.model.Member;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;

public record FindBoardDto() {
    @Builder
    public record Response(
            Long id,
            String title,
            String content,
            MemberResponse member,
            List<CouponResponse> coupons
    ) {
    }

    @Builder
    protected record MemberResponse(
            Long id,
            String name) {
    }

    @Builder
    protected record CouponResponse(
            Long id,
            String name
    ) {
    }

    public static Response of(Board board, Member member) {
        return Response.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .member(memberOf(member))
                .coupons(member.getCoupons().stream().map(FindBoardDto::couponOf)
                        .collect(Collectors.toList()))
                .build();
    }

    private static MemberResponse memberOf(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .build();
    }

    private static CouponResponse couponOf(Coupon coupon) {
        return CouponResponse.builder()
                .id(coupon.getId())
                .name(coupon.getName())
                .build();
    }
}
