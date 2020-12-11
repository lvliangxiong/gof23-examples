package com.joey.learning.gof23.creational.builder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoeyAirshipBuilder implements AirshipBuilder {

    @Override
    public Engine buildEngine() {
        log.info("构建发动机");
        return new Engine("Joey 牌发动机！");
    }

    @Override
    public EscapeTower buildEscapeTower() {
        log.info("构建逃逸塔");
        return new EscapeTower("Joey 牌逃逸塔");
    }

    @Override
    public OrbitalModule BuildOrbitalModule() {
        log.info("构建轨道舱");
        return new OrbitalModule("Joey 牌轨道舱");
    }

}
