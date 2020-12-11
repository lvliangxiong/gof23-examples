package com.joey.learning.gof23.creational.builder;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class AirshipDirectorTest {

    @Test
    void directAirship() {
        Airship airship = new JoeyAirshipDirector(new JoeyAirshipBuilder()).directAirship();
        airship.launch();
        log.info("{}", airship);
    }
}