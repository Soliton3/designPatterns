package com.dp.factoryModel;

public class Carfactory {
    public Moveable create(){
        System.out.println("a car created!");
        return new Car();
    }
}
