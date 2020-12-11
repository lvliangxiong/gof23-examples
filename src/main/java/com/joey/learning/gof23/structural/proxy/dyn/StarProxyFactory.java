package com.joey.learning.gof23.structural.proxy.dyn;

import com.joey.learning.gof23.structural.proxy.RealStar;
import com.joey.learning.gof23.structural.proxy.Star;

import java.lang.reflect.Proxy;

/**
 * @author LiangxiongLyu
 * @version 1.0
 * @date 7/14/2020
 */
public class StarProxyFactory {
    public static Star getProxy(Star target) {
        StarProxyInvocationHandler handler = new StarProxyInvocationHandler();
        handler.setTarget(target);
        // 通过 JDK 生成动态代理类，并直接生成该代理类对象
        // 动态生成代理对象需要指定『使用的类加载器』和『需要实现的接口』，以及『调用代理方法时进行处理的处理器』
        Star dynamicProxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class}, handler);
        return dynamicProxy;
    }
}
