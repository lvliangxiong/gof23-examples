package com.joey.learning.gof23.structural.proxy.dyn;

import com.joey.learning.gof23.structural.proxy.Star;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * JDK 动态代理需要自定义 InvocationHandler 的实现类
 */
@Slf4j
public class StarProxyInvocationHandler implements InvocationHandler {
    // 需要被代理的对象
    private Star target;

    public StarProxyInvocationHandler() {
    }

    public StarProxyInvocationHandler(Star target) {
        this.target = target;
    }

    public void setTarget(Star target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws InvocationTargetException, IllegalAccessException {
        StarUtils.contract(target);
        StarUtils.prepare();
        // 反射调用真实对象的方法
        method.invoke(target, args);
        StarUtils.end();
        return null;
    }
}
