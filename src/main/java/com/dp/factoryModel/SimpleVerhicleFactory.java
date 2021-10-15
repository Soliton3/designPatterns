package com.dp.factoryModel;

/*
    简单工厂可拓展性不好
 */
public class SimpleVerhicleFactory {
    public Car createCar(){
        System.out.println("a car created!");
        return new Car();
    }

    public Plane createPlane(){
        System.out.println("a Plane created!");
        return new Plane();
    }

    public Motor createMotor(){
        System.out.println("a Motor created!");
        return new Motor();
    }
}
