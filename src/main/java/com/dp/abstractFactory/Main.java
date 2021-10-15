package com.dp.abstractFactory;

import com.dp.factoryModel.Carfactory;
import com.dp.factoryModel.Moveable;

public class Main {
    public static void main(String[] args) {
        AbstractFactory modern = new MagicFactory();
        Vehicle c = modern.createVehicle();
        c.go();
        Food f = modern.createFood();
        f.printName();
        Weapon w = modern.createWeapon();
        w.shoot();
    }
}
