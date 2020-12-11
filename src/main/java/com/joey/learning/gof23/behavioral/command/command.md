# 命令模式

Command 模式，又称为 Action 模式、Transaction 模式。数据库的事务处理机制的底层就使用到了命令模式和备忘录模式。

命令模式的核心在于：抽象出命令 Command，Command 对象中包含其 Receiver 的引用，因此 Invoker 可以不用直接和 Receiver 打交道。我们可以很方便地在 Invoker 或者 Command 的具体实现类中，对 Command 进行批处理、前后处理、缓存、记录日志等等。

## 应用

- Struct2 中，action 的整个调用过程中就有命令模式

- 数据库事务机制的底层实现

- 命令的撤销和恢复（与备忘录模式一起使用）