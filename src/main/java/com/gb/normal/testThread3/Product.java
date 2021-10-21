package com.gb.normal.testThread3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Product {
    private String brand;
    private String name;

    Lock lock = new ReentrantLock();

    //生产者等待队列
    Condition produceCondition = lock.newCondition();
    //消费者等待队列
    Condition consumeCondition = lock.newCondition();
    //false表示没有产品
    boolean flag = false;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //生产商品
    public void setProduct(String brand,String name){
        lock.lock();
        try {
            if (flag == true){
                try {
                    produceCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.setBrand(brand);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setName(name);

            System.out.println("生产者生产了：" + this.getBrand() + "---" + this.getName());
            //生产完变色
            flag = true;
            //告诉消费者消费
//        notify();
            consumeCondition.signal();
        }finally{
            lock.unlock();
        }
    }
    //消费商品
    public void getProduct(){
        lock.lock();
        try {
            if (flag == false){
                try {
//                    wait();
                    consumeCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //有商品，消费
            System.out.println("消费者消费了：" + this.getBrand() + "---" + this.getName());
            flag = false;
//            notify();
            produceCondition.signal();
        }finally {
            lock.unlock();
        }

    }
}
