package com.joey.learning.gof23.behavioral.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegularCustomerMassStrategy implements Strategy {
    @Override
    public double getPrice(double normalPrice) {
        log.info("打八折");
        return normalPrice * 0.8;
    }
}
