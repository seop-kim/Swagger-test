package com.swagger.example.member.service;

import com.swagger.example.coupon.model.Coupon;
import com.swagger.example.coupon.repository.CouponRepository;
import com.swagger.example.member.dto.AddMemberDto;
import com.swagger.example.member.model.Member;
import com.swagger.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final CouponRepository couponRepository;

    public AddMemberDto.Response addMember(AddMemberDto.Request request) {
        Member member = AddMemberDto.toEntity(request);
        memberRepository.save(member);

        // log
        log.info("Member Id : " + member.getId());

        Coupon coupon = Coupon.builder().name("회원가입 축하 쿠폰").member(member).build();
        coupon.addMember(member);
        couponRepository.save(coupon);

        return AddMemberDto.of(member.getId());
    }
}
