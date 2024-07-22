package com.swagger.example.coupon.controller;

import com.swagger.example.coupon.service.CouponService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Coupon-API", description = "쿠폰 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/coupons")
public class CouponController {
    private final CouponService service;
}
