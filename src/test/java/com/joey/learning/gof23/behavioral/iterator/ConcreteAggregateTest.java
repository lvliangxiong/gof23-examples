package com.joey.learning.gof23.behavioral.iterator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ConcreteAggregateTest {
    @Test
    void iterate() {
        ConcreteAggregate cma = new ConcreteAggregate<>();
        cma.addObject("aa");
        cma.addObject("bb");
        cma.addObject("cc");

        Iterator iter = cma.createIterator();
        while (iter.hasNext()) {
            log.info("{}", iter.next());
        }
    }
}