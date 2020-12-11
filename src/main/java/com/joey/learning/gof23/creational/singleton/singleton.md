# 单例模式

## 特点

1. 构造器私有，不允许外部调用 new 关键字进行实例化
2. 提供静态方法获取该类的实例，调用该方法返回的实例永远是同一个实例

## 分类

1. 饿汉式
2. 懒汉式

其实就是懒加载（懒汉式）和非懒加载（饿汉式）。一般来说，我们更倾向于懒加载。在常见的单例模式的实现中，DCL，也就是 Double Check Lock 就是比较典型的懒加载。

**值得一提的是，如何保证非懒加载？**

其实并没有什么比较好的办法，只能在系统启动的时候，手动调用创建单例的静态方法，从而实现非懒加载。

许多博客和视频教程上说的使用 static 静态变量在类加载时，直接初始化单例属于非懒加载，这个在 `JDK` 版本比较低的时候，可能还是正确的，但是现在比较新的 JDK 在第一次使用该类时，才会进行类的加载，也不能算是严格意义上的非懒加载。而且依赖类加载来实现非懒加载是不靠谱的，因为这种做法将类的行为和 JVM 的行为进行的绑定，对于不同的 JVM 实现和版本可能会造成不同的行为，建议不要这样使用。

相反，如果本身对单例的懒加载和非懒加载并没有什么特殊的要求时，各种单例的实现均是可以的。


## 各种单例模式可能的缺陷

1. 只要存在私有构造器，那么就存在通过反射调用私有构造器，破坏单例模式的可能。
2. 如果该类实现了 Serializabe 或者 Externalizable 接口，就有可能通过反序列化破解单例模式。
3. 使用克隆进行破解

### 反射调用私有构造器

一般的解决方式就是在构造器中进行判断，保证该构造器不能被成功调用超过一次。

例如对于 Double Check Lock 实现的单例：

```
public class DoubleCheckLockSingleton {
    private volatile static DoubleCheckLockSingleton instance;

    private DoubleCheckLockSingleton() {
        if (instance != null)
            throw new RuntimeException("multiple invocation of this private constructor");
    }

    public static DoubleCheckLockSingleton getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (DoubleCheckLockSingleton.class) {
            if (instance != null) return instance;
            instance = new DoubleCheckLockSingleton();
        }
        return instance;
    }
}
```

大部分博客或书籍上的 Double Check 单例实现，均是在 getInstance 方法中使用了 Double Check 的技巧，但是忽略了一点的就是：如果第一次调用私有构造方法是通过的反射调用的，那么会发生什么？

明显，就会出现多个单例类的实例，而这是不允许的。

所以笔者建议在构造器中，也进行一次 double lock check，并使用 synchronized 关键字进行加锁。如下：

```
    private DoubleCheckLockSingleton() {
        if (instance != null)
            throw new RuntimeException("multiple invocation of this private constructor");

        // 仔细想想下面几行代码到底有什么用？
        synchronized (DoubleCheckLockSingleton.class) {
            if (instance != null)
                throw new RuntimeException("multiple invocation of this private constructor");
            instance = this;
        }
    }
```

这里笔者给出的实现，在构造方法中对 instance 进行了赋值和 Double Check，保证了无论是反射还是 new 关键字，只要是第一次调用构造方法，那么就会对 instance 变量赋值，并且后续再次调用全部会抛出异常。

并且由于 DCL 的存在，getInstance 不可能重复调用构造方法，因此不需要进行异常处理。

反射倒是有可能同时进入构造方法，从而需要保证构造方法仅被成功调用一次。抛出的异常由调用者自己进行处理。

#### volatile 与指令重排

DCL 实现的懒加载的单例模式有因指令重排导致异常的可能。

问题在于 getInstance 方法中的 `instance = new DoubleCheckLockSingleton();`，这一行代码并不是一个原子性操作，它起码可以可以分为以下几个步骤：

1. 为创建对象分配内存地址和空间
2. 调用构造方法，进行实例化
3. 将 a 中分配的地址赋值给 instance 变量

可以看出，操作 b 和 c 依赖于操作 a，但是操作 b 和操作 c 没有依赖关系。

由于指令重排的存在（指令重排），如果 instance 变量是一个普通变量（没有被 volatile 修饰），那么操作 b 和操作 c 的顺序，可能就会出现重排，也就是说操作 c 先于操作 b 完成，特别是在操作 b 十分耗时的情况下。

那么操作 c 完成后，instance 变量就不是 null 了，如果此时刚好有**另外一个线程**抢占到 CPU，并且执行类似于如下的伪代码：

```
DoubleCheckLockSingleton instance = DoubleCheckLockSingleton.getInstance();
if (instance != null) {
	instance.fun();
}
```

显而易见，这段代码会发生异常，因为 instance 变量已经不是 null，因此 getInstance 会直接返回 instance，但是它指向的对象还没有实例化完成，后续的方法调用就会出错。

那么如何解决这样一个问题呢？这就是 volatile 关键字的作用了。


### 反序列化

首先需要说明的是，该单例类需要实现了 Serializable 或者 Externalizable 接口，才可能会出现反序列化破解单例的情况。

对于满足条件的单例类，这种风险可以通过在单例类中实现一个方法进行规避。该方法的声明如下：

```
    ANY-ACCESS-MODIFIER Object readResolve()
            throws ObjectStreamException;
```

由于序列化，反序列化都是已经实例化之后才会进行的。所以在进行反序列化时，已经有了该单例对象，对于 Double Check Lock 类型的单例，也就是说静态变量 instance 已经有值了，所以直接返回 instance 变量的值即可。
```
    private Object readResolve() throws ObjectStreamException {
        // 无视反序列化生成的对象，直接返回已经实例化的 instance
        return instance;
    }
```

此方法的返回值，会替代反序列化的结果，返回给调用者。因此，重新保证了单例不被破坏。

参考：<a href="https://docs.oracle.com/javase/7/docs/platform/serialization/spec/input.html#5903">Java Object Serialization Specification</a>

### clone

当此单例类实现了 Cloneable 借口，就有可能出现 clone 破坏单例的情况。

解决方法就是对 clone 方法进行重写。

```
    @Override
    protected Object clone() {
        return instance;
    }
```

