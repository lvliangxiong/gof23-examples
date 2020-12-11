package com.joey.learning.gof23.behavioral.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * 经理
 */
@Slf4j
public class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 10) {
            log.info("员工：{} 请假天数：{} 理由：{}", request.getEmpName(), request.getLeaveDays(), request.getReason());
            log.info("经理：{}，审批通过！", name);
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}