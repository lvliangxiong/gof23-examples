package com.joey.learning.gof23.structural.bridge;

import lombok.extern.slf4j.Slf4j;

public interface Brand {
    String info();
}

@Slf4j
class Lenovo implements Brand {
    @Override
    public String info() {
        return "联想";
    }
}


class Asus implements Brand {
    @Override
    public String info() {
        return "华硕";
    }
}