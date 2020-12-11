package com.joey.learning.gof23.behavioral.strategy;

import org.junit.jupiter.api.Test;

class PriceQuotingTest {
    @Test
    void printPrice() {
        PriceQuoting pq = new PriceQuoting(new RegularCustomerMassStrategy());
        pq.printPrice(998);

        pq.setStrategy(new NewCustomerFewStrategy());
        pq.printPrice(998);
    }
}