package com.dp.proxy;

import java.util.Random;

/**
 * 静态代理模式
 */
public class Main implements Movable{

    @Override
    public void move() {
        System.out.println("do something...");
        try{
            Thread.sleep(new Random().nextInt(10000));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TankTimeProxy(
                new TankLogProxy(
                        new Main()
                )
        ).move();
    }
}

class TankTimeProxy implements Movable{
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements Movable{
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("Start moving...");
        m.move();
        System.out.println("stooped!");
    }
}

interface Movable{
    void move();
}
