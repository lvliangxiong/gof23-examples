# 策略模式

## 场景

客户需要购买一批设备，向生产该设备的公司询价。公司就会根据客户的类型使用不同的报价策略。当客户的种类越来越多时，报价的策略就会越来越多，代码会变得十分繁琐、不易维护，因此可以使用策略模式。

## 目的

策略模式对应于解决某一问题的算法族，允许用户从这些算法中选择一个算法用于解决问题，同时方便更换算法或者增加算法。

这里的算法就可以理解为解决某一问题的策略。

## 本质

分离算法、选择实现！

## 应用

- JavaSE 的 GUI 编程中的布局管理
- Spring 框架中，Resource 接口，资源访问策略
- javax.servlet.http.HttpServlet#service()
- java.util.Comparator#compare()
- java.servlet.Filter#doFilter()


