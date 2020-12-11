package com.joey.learning.gof23.behavioral.chainofresponsibility;


import lombok.extern.slf4j.Slf4j;

/**
 * 主任
 */
@Slf4j
public class Director extends Leader {

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 3) {
            log.info("员工：{} 请假天数：{} 理由：{}", request.getEmpName(), request.getLeaveDays(), request.getReason());
            log.info("主任：{}，审批通过！", name);
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}