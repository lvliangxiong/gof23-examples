# 解释器模式

## 应用

- EL 表达式的处理
- 正则表达式解释器
- `SQL` 语法解释器
- 数学表达式解释器
  - 如现成的工具包：Math Expression String Parser（MESP），Expression4J 等

解释器模式在实际的软件开发中使用比较少，因为它会引起效率、性能以及维护等问题。

以下均是解释器模式在 JDK 中的应用：

```
java.util.Pattern
java.text.Normalizer
java.text.Format
java.el.ELResolver
```

