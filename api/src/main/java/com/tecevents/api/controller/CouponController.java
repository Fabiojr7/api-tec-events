package com.tecevents.api.controller;

import com.tecevents.api.domain.coupon.Coupon;
import com.tecevents.api.domain.coupon.CouponRequestDTO;
import com.tecevents.api.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<Coupon> addCouponsToEvent(@PathVariable UUID eventId, @RequestBody CouponRequestDTO data){
        Coupon newCoupon = this.couponService.addCouponsToEvent(eventId, data);
        return ResponseEntity.ok(newCoupon);
    }
}
