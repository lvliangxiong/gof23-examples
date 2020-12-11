package com.joey.learning.gof23.structural.proxy.dyn;

import com.joey.learning.gof23.structural.proxy.RealStar;
import com.joey.learning.gof23.structural.proxy.Star;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 为了将 JDK 动态生成的代理对象的字节码保存下来，不能使用 Junit 框架，只能使用 main 方法运行。
 */
@Slf4j
public class DynProxyTest {
    public static void main(String[] args) {
        // 设置环境变量，使得 JDK 动态生成的代理对象的字节码会被保存在硬盘上
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Star realStar = new RealStar("Jason, Zhou");
        // 使用动态代理
        Star proxy = StarProxyFactory.getProxy(realStar);
        log.info("{}", proxy.getClass());

        // 对代理对象所有方法的调用都会转而调用与代理对象绑定的 InvocationHandler 对象的 invoke 方法进行处理
        proxy.work();
    }
}


