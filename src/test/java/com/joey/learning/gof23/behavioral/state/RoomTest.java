package com.joey.learning.gof23.behavioral.state;

import org.junit.jupiter.api.Test;

class RoomTest {

    @Test
    void setState() {
        Room room = new Room();
        room.reserve();
        room.checkIn();
        room.checkOut();
    }
}