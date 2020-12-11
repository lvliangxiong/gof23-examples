# 工厂模式

实现了创建者和调用者的分离。

## 分类

- 简单工厂，又称为静态工厂

  不满足 `OCP`，增加新的产品后，需要修改工厂类。

- 工厂方法模式

  解决简单工厂不满足 `OCP` 的缺点，但是对于每一种产品，都需要有相应的工厂类，将创建对象的工作推迟到工厂接口的实现类或者工厂类的子类中完成。

- 抽象工厂模式

  用于处理产品族的全部产品。对于增加新的产品无能为力，但是可以增加产品族。

## 应用

- JDK 中 Calendar 的 getInstance 方法

  ```java
  // 使用默认的时区和时间（当前时间）创建一个 Calendar 对象
  Calendar cal = Calendar.getInstance();
  ```

- `JDBC` 中 Connection 对象的获取

  ```java
  Class.forName(JDBC_DRIVER);
  Connection conn = DriverManager.getConnection(DB_URL, USER, PWD);
  ```

- Spring 中 IOC 容器创建管理 bean 对象

- XML 解析时，`DocumentBuilderFactory` 创建解析器对象

- 反射中 Class 对象的 `newInstance` 方法




