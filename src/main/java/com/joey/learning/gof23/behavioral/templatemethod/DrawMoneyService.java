package com.joey.learning.gof23.behavioral.templatemethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DrawMoneyService extends BankService {
    @Override
    public void service() {
        log.info("我要取款！！！");
    }
}
