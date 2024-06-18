package com.tecevents.api.service;


import com.tecevents.api.domain.coupon.Coupon;
import com.tecevents.api.domain.coupon.CouponRequestDTO;
import com.tecevents.api.domain.event.Event;
import com.tecevents.api.repositories.CouponRepository;
import com.tecevents.api.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CouponService {

    private final CouponRepository couponRepository;

    private final EventRepository eventRepository;

    public Coupon addCouponsToEvent(UUID eventId, CouponRequestDTO couponData){


        Coupon newCoupon = new Coupon();
        newCoupon.setCode(couponData.code());
        newCoupon.setDiscount(couponData.discount());
        newCoupon.setValid(new Date(couponData.valid()));
        newCoupon.setEvent(eventRepository.findById(eventId).orElseThrow(() -> new IllegalStateException("Event not found")));

        couponRepository.save(newCoupon);

        return newCoupon;
    }

    public List<Coupon> consultCoupons(UUID eventId, Date currentDate) {
        return couponRepository.findByEventIdAndValidAfter(eventId, currentDate);
    }
}
