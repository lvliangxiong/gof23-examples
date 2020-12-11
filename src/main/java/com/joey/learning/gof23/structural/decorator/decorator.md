# 装饰器模式

装饰器模式，又称为装饰模式、包装器（Wrapper）模式、包装模式。

## 核心

为对象动态添加功能。

装饰器模式是一种用于替代继承的技术，无须通过继承增加子类就可以扩展对象的功能。

使用对象的关联关系代替继承关系，更加灵活，同时避免了类型体系的快速膨胀。

## 应用

- IO 流的设计
- Swing 包中图形界面构件功能
- Servlet API 中提供了一个 request 对象的 Decorator 设计模式的默认实现类：HttpServletRequestWrapper