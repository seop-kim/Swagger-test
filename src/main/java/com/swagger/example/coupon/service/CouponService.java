package com.swagger.example.coupon.service;

import com.swagger.example.coupon.repository.CouponRepository;
import com.swagger.example.member.dto.AddMemberDto;
import com.swagger.example.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CouponService {
    private final CouponRepository repo;
}
