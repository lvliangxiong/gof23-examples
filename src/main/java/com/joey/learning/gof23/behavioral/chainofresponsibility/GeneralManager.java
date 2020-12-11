package com.joey.learning.gof23.behavioral.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * 总经理
 */
@Slf4j
public class GeneralManager extends Leader {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 30) {
            log.info("员工：{} 请假天数：{} 理由：{}", request.getEmpName(), request.getLeaveDays(), request.getReason());
            log.info("总经理：{}，审批通过！", name);
        } else {
            log.info("莫非{}想辞职，居然请假{}天！", request.getEmpName(), request.getLeaveDays() + "");
        }
    }
}