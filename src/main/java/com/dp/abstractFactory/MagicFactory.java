package com.dp.abstractFactory;

public class MagicFactory extends AbstractFactory{
    @Override
    Food createFood() {
        return new Noodle();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicTick();
    }
}
