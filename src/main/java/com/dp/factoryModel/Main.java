package com.dp.factoryModel;

public class Main {
    public static void main(String[] args) {
        Moveable moveable = new Carfactory().create();
        moveable.go();
    }
}
