package com.joey.learning.gof23.structural.decorator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author LiangxiongLyu
 * @version 1.0
 * @date 7/3/2020
 */
@NoArgsConstructor
@AllArgsConstructor
abstract class Beverage {
    protected int price;

    abstract int cost();
}

class Cola extends Beverage {
    public Cola() {
        super(5);
    }

    @Override
    int cost() {
        return price;
    }
}

class Coffee extends Beverage {
    public Coffee() {
        super(15);
    }

    @Override
    int cost() {
        return price;
    }
}

abstract class BeverageDecorator extends Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}

class Milk extends BeverageDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    int cost() {
        return beverage.price + 2;
    }
}

class Mocha extends BeverageDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    int cost() {
        return beverage.price + 1;
    }
}

class Sugar extends BeverageDecorator {
    public Sugar(Beverage beverage) {
        super(beverage);
    }

    @Override
    int cost() {
        return beverage.price + 1;
    }
}
