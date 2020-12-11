package com.joey.learning.gof23.behavioral.mediator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediatorTest {
    @Test
    void main() {
        Mediator manager = new President();

        Market market = new Market(manager);
        Development development = new Development(manager);
        Financial financial = new Financial(manager);

        market.selfAction();
        market.outAction();
        development.outAction();
        financial.outAction();
    }
}