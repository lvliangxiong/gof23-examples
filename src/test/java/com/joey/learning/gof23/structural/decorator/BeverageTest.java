package com.joey.learning.gof23.structural.decorator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author LiangxiongLyu
 * @version 1.0
 * @date 7/3/2020
 */
@Slf4j
class BeverageTest {

    @Test
    void decorate() {
        Beverage cola = new Cola();
        Beverage coffee = new Coffee();
        log.info("cola: {} RMB", cola.cost());
        log.info("coffee: {} RMB", coffee.cost());

        Beverage colaWithSugar = new Sugar(new Cola());
        log.info("cola with sugar: {} RMB", colaWithSugar.cost());
        Beverage colaWithSugarAndMilk = new Milk(colaWithSugar);
        log.info("cola with sugar and milk: {} RMB", colaWithSugarAndMilk.cost());

    }
}