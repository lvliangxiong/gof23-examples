package com.joey.learning.gof23.structural.proxy.sta;

import com.joey.learning.gof23.structural.proxy.Star;
import lombok.extern.slf4j.Slf4j;

/**
 * 静态代理
 */
@Slf4j
public class StarProxy implements Star {

    private Star star;

    public StarProxy(Star star) {
        this.star = star;
    }

    /**
     * 签合约
     */
    public void contract() {
        log.info("Proxy is signing the contract for {}...", star);
    }

    /**
     * 准备
     */
    public void prepare() {
        log.info("Proxy is preparing ...");
    }

    /**
     * 收尾工作
     */
    public void end() {
        log.info("Proxy is handling the remaining work ...");
    }

    /**
     * 工作
     */
    @Override
    public void work() {
        contract();
        prepare();
        star.work();
        end();
    }
}
