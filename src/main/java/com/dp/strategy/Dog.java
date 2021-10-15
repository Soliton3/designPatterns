package com.dp.strategy;

public class Dog {
    private int speed;

    public Dog(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "speed=" + speed +
                '}';
    }
}
