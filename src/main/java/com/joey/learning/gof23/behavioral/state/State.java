package com.joey.learning.gof23.behavioral.state;

import lombok.extern.slf4j.Slf4j;

public interface State {
    // 不同的状态有着不同的行为
    void info();

    void reserve();

    void checkIn();

    void checkOut();
}

/**
 * 空闲
 */
@Slf4j
class FreeState implements State {
    private Room room;

    public FreeState(Room room) {
        this.room = room;
    }

    @Override
    public void info() {
        log.info("房间空闲，没人住！");
    }

    @Override
    public void reserve() {
        log.info("房间被预订");
        room.setState(room.getReservedState());
    }

    @Override
    public void checkIn() {
        log.info("请先预订房间！");
    }

    @Override
    public void checkOut() {
        log.info("未预订和入住，无法退房");
    }

    @Override
    public String toString() {
        return "空闲";
    }
}

/**
 * 已预订
 */
@Slf4j
class ReservedState implements State {
    private Room room;

    public ReservedState(Room room) {
        this.room = room;
    }

    @Override
    public void info() {
        log.info("房间已预定！");
    }

    @Override
    public void reserve() {
        log.info("房间已预定！请勿重复操作！");
    }

    @Override
    public void checkIn() {
        log.info("成功入住！");
        room.setState(room.getCheckedInState());
    }

    @Override
    public void checkOut() {
        log.info("未入住，无法退房");
    }

    @Override
    public String toString() {
        return "已预定";
    }
}

/**
 * 已入住
 */
@Slf4j
class CheckedInState implements State {
    private Room room;

    public CheckedInState(Room room) {
        this.room = room;
    }

    @Override
    public void info() {
        log.info("房间已入住，请勿打扰！");
    }

    @Override
    public void reserve() {
        log.info("重新预订，续房成功！");
    }

    @Override
    public void checkIn() {
        log.info("已办理入住手续，无需重复办理！");
    }

    @Override
    public void checkOut() {
        log.info("退房成功！");
        room.setState(room.getFreeState());
    }

    @Override
    public String toString() {
        return "已入住";
    }
}