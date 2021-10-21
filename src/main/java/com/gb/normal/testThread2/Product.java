package com.gb.normal.testThread2;

public class Product {
    private String brand;
    private String name;

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
    public synchronized void setProduct(String brand,String name){
        if (flag == true){
            try {
                wait();
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
        notify();
    }
    //消费商品
    public synchronized void getProduct(){
        if (flag == false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //有商品，消费
        System.out.println("消费者消费了：" + this.getBrand() + "---" + this.getName());
        flag = false;
        notify();
    }
}
