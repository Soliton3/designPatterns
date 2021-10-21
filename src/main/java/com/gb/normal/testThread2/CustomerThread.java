package com.gb.normal.testThread2;

public class CustomerThread extends Thread{
    //共享商品
    private Product p;
    public CustomerThread(Product p){
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            p.getProduct();
        }
    }
}
