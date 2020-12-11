package com.joey.learning.gof23.structural.flyweight;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class ChessTest {

    @Test
    void display() {
        // 工厂模式，创建对象
        Chess chess1 = ChessFlyWeightFactory.getChess("黑色");
        Chess chess2 = ChessFlyWeightFactory.getChess("黑色");

        chess1.display(new Coordinate(10, 10));
        chess2.display(new Coordinate(20, 20));

        Assertions.assertTrue(chess1 == chess2);
    }
}