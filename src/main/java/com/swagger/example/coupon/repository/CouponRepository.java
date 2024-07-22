package com.swagger.example.coupon.repository;

import com.swagger.example.coupon.model.Coupon;
import com.swagger.example.member.model.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class CouponRepository {
    private static final Map<Long, Coupon> coupons = new HashMap<>();
    private static Long id = 1L;

    public Long save(Coupon coupon) {
        coupon.addId(id);
        coupons.put(id, coupon);
        id++;
        return coupon.getId();
    }

    public Long update(Long id, Coupon coupon) {
        coupon.addId(id);
        coupons.put(id, coupon);
        return coupon.getId();
    }

    public Coupon findOne(Long id) {
        return coupons.get(id);
    }

    public List<Coupon> findAll() {
        return new ArrayList<>(coupons.values());
    }
}
