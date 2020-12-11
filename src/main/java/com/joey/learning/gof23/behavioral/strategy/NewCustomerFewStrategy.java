package com.joey.learning.gof23.behavioral.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NewCustomerFewStrategy implements Strategy {
    @Override
    public double getPrice(double normalPrice) {
        log.info("不打折，原价");
        return normalPrice;
    }
}
