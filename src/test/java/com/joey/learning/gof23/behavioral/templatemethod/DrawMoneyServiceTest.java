package com.joey.learning.gof23.behavioral.templatemethod;

import org.junit.jupiter.api.Test;

/**
 * @author LiangxiongLyu
 * @version 1.0
 * @date 8/6/2020
 */
class DrawMoneyServiceTest {
    @Test
    void transact() {
        BankService bs = new DrawMoneyService();
        bs.process();
    }
}