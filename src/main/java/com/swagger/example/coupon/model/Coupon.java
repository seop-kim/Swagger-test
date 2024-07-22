package com.swagger.example.coupon.model;

import com.swagger.example.member.model.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Coupon {
    private Long id;
    private Member member;
    private String name;

    public void addId(Long id) {
        this.id = id;
    }

    public void addMember(Member member) {
        this.member = member;
        member.getCoupons().add(this);
    }
}
