package com.gb.normal.testThread3;

public class ProducerThread extends Thread{
    //共享商品
    private Product p;

    public ProducerThread(Product p){
        this.p = p;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0){
                p.setProduct("德芙","巧克力");
            }else{
                //生产青岛啤酒
                p.setProduct("青岛","啤酒");
            }
        }
    }
}
