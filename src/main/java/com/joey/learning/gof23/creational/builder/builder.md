# 建造者模式

## 核心

对象子组件的构造由 `Buidler` 负责，装配由 `Director` 来负责。

构建和装配的解耦，实现了更好的复用。

## 应用

- StringBuilder 中的 append 方法
- SQL 中的 PreparedStatement
- JDOM 中，DomBuilder、SAXBuilder