package com.joey.learning.gof23.behavioral.state;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 房间对象，如果是银行系统，那么这个类就是银行账户
 */
@Slf4j
@Getter
public class Room {

    private State freeState;

    private State reservedState;

    private State checkedInState;

    private State state;

    public Room() {
        freeState = new FreeState(this);
        reservedState = new ReservedState(this);
        checkedInState = new CheckedInState(this);
        state = freeState;
        log.info("当前状态为：{}", state);
    }

    public void setState(State state) {
        log.info("修改状态为：{}", state);
        this.state = state;
        state.info();
    }

    public void reserve() {
        state.reserve();
    }

    public void checkIn() {
        state.checkIn();
    }

    public void checkOut() {
        state.checkOut();
    }

}

