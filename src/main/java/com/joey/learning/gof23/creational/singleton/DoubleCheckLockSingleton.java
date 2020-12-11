package com.joey.learning.gof23.creational.singleton;

import lombok.extern.slf4j.Slf4j;

import java.io.Externalizable;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 双重锁检测实现单例模式
 */
public class DoubleCheckLockSingleton implements Serializable, Cloneable {
    /**
     * 使用私有静态变量，储存此实例。
     * <p>
     * volatile 关键字的作用：
     * 1. 保证了一个线程对此类进行实例化后，对其它线程立即可见（可见性）
     * 2. 避免指令重拍导致的错误（顺序性）
     */
    private volatile static DoubleCheckLockSingleton instance;

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

    public static DoubleCheckLockSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (instance == null)
                    instance = new DoubleCheckLockSingleton();
            }
        }
        return instance;
    }

    /**
     * 对于实现了 {@link Serializable} 或 {@link Externalizable} 接口的类，
     * readResolve 方法允许在反序列化时替换最终返回给调用者的对象。
     * <p>
     * 该方法的定义如下：
     * <pre>
     * 	ANY-ACCESS-MODIFIER Object readResolve()
     *     		throws ObjectStreamException;
     * </pre>
     * 此方法的返回值会替换原有的反序列化得到的对象。
     *
     * @return
     * @throws ObjectStreamException
     * @see <a href="https://docs.oracle.com/javase/7/docs/platform/serialization/spec/input.html#5903">
     * Java Object Serialization Specification</a>
     */
    private Object readResolve() throws ObjectStreamException {
        // 无视反序列化生成的对象，直接返回已经实例化的 instance
        return instance;
    }

    @Override
    protected Object clone() {
        return instance;
    }
}
