# 观察者模式

## 场景

- 广播机制
- 消息订阅
- 网络游戏对战

多个订阅者、客户称之为**观察者**；需要同步给对个观察者的数据封装到对象中，称之为**目标**。

## 核心

主要用于 1 对 N 的通知。当一个对象（目标对象，消息的发布者，Subject 或者 Observable）的状态变化时，它就会及时告知一系列的对象（观察者对象，消息的订阅者，Observer），令它们作出反应。

## 应用

- `Servlet` 中监听器的实现
- JDK 的 `AWT` 中的事件处理模型是基于观察者模式的委派事件模型

