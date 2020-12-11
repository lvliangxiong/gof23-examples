package com.joey.learning.gof23.creational.builder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoeyAirshipDirector implements AirshipDirector {

    private AirshipBuilder builder;

    public JoeyAirshipDirector(AirshipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public Airship directAirship() {
        Engine e = builder.buildEngine();
        OrbitalModule o = builder.BuildOrbitalModule();
        EscapeTower et = builder.buildEscapeTower();

        // 装配成飞船对象
        Airship ship = new Airship();
        ship.setEngine(e);
        ship.setEscapeTower(et);
        ship.setOrbitalModule(o);
        log.info("组装 Joey 牌飞船");

        return ship;
    }
}
