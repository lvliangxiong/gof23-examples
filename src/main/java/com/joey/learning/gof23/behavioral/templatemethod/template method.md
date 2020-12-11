# 模板方法模式

## 场景

1. 客户去银行办理业务：
   1. 取号、排队
   2. 办理具体的业务
   3. 给银行工作人员评分
2. 请客吃饭
   1. 点单
   2. 吃东西
   3. 买单

## 介绍

模板方法模式定义了一个操作中的算法骨架，将某些步骤延迟到子类中实现。这样，一个新的子类就可以在不改变一个算法结构的前提下重新定义该算法的某些特定的步骤。

模板方法，又被称为方法回调，或者钩子方法。

## 核心

处理的步骤在父类中定义好，某些步骤的具体实现延迟到子类中进行定义。

通过模板方法，子类可以重新定义算法的某些步骤，而不用改变算法的结构。

## 应用

- 数据库访问的封装

- `Junit` 单元测试

- `servlet` 中关于 `doGet`、`doPost` 方法的调用

- Hibernate 中的模板程序

- Spring 中 `JDBCTemplate`、`HibernateTemplate` 等

- ```
  java.util.Collections#sort()
  java.io.InputStream#skip()
  java.io.InputStream#read()
  java.util.AbstractList#indexOf()
  ```



