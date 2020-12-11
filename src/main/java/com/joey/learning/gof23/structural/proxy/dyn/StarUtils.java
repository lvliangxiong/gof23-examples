package com.joey.learning.gof23.structural.proxy.dyn;

import com.joey.learning.gof23.structural.proxy.Star;
import lombok.extern.slf4j.Slf4j;

/**
 * @author LiangxiongLyu
 * @version 1.0
 * @date 7/14/2020
 */
@Slf4j
public class StarUtils {

    /**
     * 签合约
     */
    public static void contract(Star star) {
        log.info("Proxy is signing the contract for {} ...", star);
    }

    /**
     * 准备
     */
    public static void prepare() {
        log.info("Proxy is preparing ...");
    }

    /**
     * 收尾工作
     */
    public static void end() {
        log.info("Proxy is handling the remaining work ...");
    }
}
