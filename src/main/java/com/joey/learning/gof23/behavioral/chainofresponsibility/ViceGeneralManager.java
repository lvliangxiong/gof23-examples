package com.joey.learning.gof23.behavioral.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * 副总经理
 */
@Slf4j
public class ViceGeneralManager extends Leader {

    public ViceGeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 20) {
            log.info("员工：{} 请假天数：{} 理由：{}", request.getEmpName(), request.getLeaveDays(), request.getReason());
            log.info("副总经理：{}，审批通过！", name);
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
