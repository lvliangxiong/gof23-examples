package com.joey.learning.gof23.structural.proxy.sta;

import com.joey.learning.gof23.structural.proxy.RealStar;
import com.joey.learning.gof23.structural.proxy.Star;
import org.junit.jupiter.api.Test;

class StarProxyTest {

    private static Star realStar = new RealStar("Jason, Zhou");

    @Test
    void work() {
        // 使用静态代理
        Star staticStarProxy = new StarProxy(realStar);
        staticStarProxy.work();
    }
}