package com.joey.learning.gof23.behavioral.chainofresponsibility;

import org.junit.jupiter.api.Test;

class LeaveRequestTest {
    @Test
    void handle() {
        Leader d = new Director("张三");
        Leader m = new Manager("李四");
        Leader vgm = new ViceGeneralManager("李小四");
        Leader gm = new GeneralManager("王五");
        // 组织责任链对象的关系
        d.setNextLeader(m);
        m.setNextLeader(vgm);
        vgm.setNextLeader(gm);
        // 开始请假操作
        LeaveRequest req = new LeaveRequest("TOM", 2, "回英国老家探亲！");
        d.handleRequest(req);
    }
}