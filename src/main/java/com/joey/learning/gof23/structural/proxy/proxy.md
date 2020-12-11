# 代理模式

## 目的

提供了一个实际对象的代理，以便更好地控制实际对象。

## 组成

1. Subject（共同接口）

   Subject 是一个接口或者抽象类，用于定义 RealSubject 和 Proxy 必须实现的方法。

2. RealSubject（真实对象）

   RealSubject  是真实对象的类，它实现了 Subject 接口或抽象类。

3. Proxy（代理对象） 

   Proxy 是代理类。==代理对象持有真实对象的引用，并且也实现了 Subject 接口或抽象类==。Proxy 对象调用 Subject 定义的方法时，可以让其持有的真实对象去完成，并且可以十分方便地在真实对象调用相应方法的前后，进行前处理和后处理工作。

## 分类

### 静态代理

开发者手动定义代理类实现的代理模式，就是静态代理。

### 动态代理

代理类的字节码是运行时动态生成的，这样实现的代理模式就是动态代理。

## 例子

Star 类，代表代理模式中的 Subject。

```java
package com.joey.learning.gof23.structural.proxy;

public interface Star {
    /**
     * 工作
     */
    public void work();
}
```

RealStar，代表代理模式中的 RealSubject。

```java
package com.joey.learning.gof23.structural.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealStar implements Star {

    private String name;

    public RealStar(String name) {
        this.name = name;
    }

    /**
     * 工作
     */
    @Override
    public void work() {
        perform();
    }

    private void perform() {
        log.info("Real star {} is performing ...", name);
    }

    @Override
    public String toString() {
        return "RealStar{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

### 静态代理类

```java
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
```

测试类

```java
package com.joey.learning.gof23.structural.proxy;

import com.joey.learning.gof23.structural.proxy.dyn.StarProxyFactory;
import com.joey.learning.gof23.structural.proxy.sta.StarProxy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author LiangxiongLyu
 * @version 1.0
 * @date 7/14/2020
 */
@Slf4j
class ProxyTest {
    Star realStar = new RealStar("Jason, Zhou");

    @Test
    public void staticProxy() {
        // 使用静态代理
        Star staticStarProxy = new StarProxy(realStar);
        staticStarProxy.work();
    }
}
```

上述例子中，我们手动定义了 Star 的代理类 StarProxy，因此这种代理模式就是静态代理。

代理对象 staticStarProxy 在调用 Star 接口中定义的 work 方法之前和之后，会执行代理类中定义的前处理和后处理方法。

### 动态代理

动态代理的实现，常用的包括 JDK 自带的动态代理支持和字节码操纵工具（如 CGlib）提供的动态代理。

JDK 自带的动态代理是 interface-based，即代理的是接口，代理对象不能强转为真实对象的类型。动态生成的代理类继承的是 `java.lang.reflect.Proxy`，并且实现了公共接口。

CGlib 的动态代理则属于 class-based，代理对象可以直接转为真实对象的类型，因为代理类继承的是具体的实现类。

这里给出使用 JDK 动态代理的例子：

```java
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
```

```java
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
```

```java
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
        // 通过 JDK 自带的代理类动态直接生成代理对象
        // 动态生成代理对象需要指定『使用的类加载器』和『需要实现的接口』，以及『调用代理方法时进行处理的处理器』
        Star dynamicProxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class}, handler);
        return dynamicProxy;
    }
}
```

测试类

```java
package com.joey.learning.gof23.structural.proxy.dyn;

import com.joey.learning.gof23.structural.proxy.RealStar;
import com.joey.learning.gof23.structural.proxy.Star;

/**
 * 为了将 JDK 动态生成的代理对象的字节码保存下来，不能使用 Junit 框架，只能使用 main 方法运行。
 */
public class DynProxyTest {
    public static void main(String[] args) {
        // 设置环境变量，使得 JDK 动态生成的代理对象的字节码会被保存在硬盘上
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Star realStar = new RealStar("Jason, Zhou");
        // 使用动态代理
        Star proxy = StarProxyFactory.getProxy(realStar);
        // 对代理对象所有方法的调用都会转而调用与代理对象绑定的 InvocationHandler 对象的 invoke 方法进行处理
        proxy.work();
    }
}
```

这里使用了工厂模式获得动态代理对象。对 JDK 自动生成的代理对象的方法调用，会在内部转为对**与代理对象绑定的 `InvocationHandler` 实现类实例**的 invoke 方法的调用。

上述测试类通过设置环境变量，JDK 会将自动生成的代理类的字节码缓存在工程目录下。

如下就是 JDK 为 Star 生成的动态代理类：

```java
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.sun.proxy;

import com.joey.learning.gof23.structural.proxy.Star;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public final class $Proxy18 extends Proxy implements Star {
    private static Method m1;
    private static Method m3;
    private static Method m2;
    private static Method m0;

    public $Proxy18(InvocationHandler var1) throws  {
        super(var1);
    }

    public final boolean equals(Object var1) throws  {
        try {
            return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    public final void work() throws  {
        try {
            super.h.invoke(this, m3, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final String toString() throws  {
        try {
            return (String)super.h.invoke(this, m2, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final int hashCode() throws  {
        try {
            return (Integer)super.h.invoke(this, m0, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m3 = Class.forName("com.joey.learning.gof23.structural.proxy.Star").getMethod("work");
            m2 = Class.forName("java.lang.Object").getMethod("toString");
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }
}
```

可以看到，它实现了 Star 接口的 work 方法，并且在内部将方法调用转发给了和它绑定的 `InvocationHandler` 实例。值得注意的是传入的第二个参数，它是代表接口中的方法 Method 对象。

```java
m3 = Class.forName("com.joey.learning.gof23.structural.proxy.Star").getMethod("work");
```

而 `InvocationHandler` 自身绑定了真实对象，也就是 `RealStar` 对象，因此我们可以使用反射对真实对象调用 `m3` 方法。

动态代理的本质就是**动态生成代理类的字节码并加载**。

## 应用

- Struts2 中拦截器的实现
- 数据库连接池的关闭处理
- Hibernate 中延迟加载的实现
- mybatis 中拦截器插件
- AspectJ 的实现
- Spring 中 AOP 的实现
  - 日志拦截
  - 声明式事务处理
- web service
- RMI 远程方法调用

