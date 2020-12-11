package com.joey.learning.gof23.creational.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airship {
    private OrbitalModule orbitalModule;  // 轨道舱
    private Engine engine; // 发动机
    private EscapeTower escapeTower;  // 逃逸塔

    public void launch() {
        log.info("发射！");
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class OrbitalModule {
    private String name;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Engine {
    private String name;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class EscapeTower {
    private String name;
}






