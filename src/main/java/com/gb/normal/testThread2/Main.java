package com.gb.normal.testThread2;

public class Main {
    public static void main(String[] args) {
        //共享商品
        Product p = new Product();
        //创建生产者和消费者线程
        ProducerThread pt = new ProducerThread(p);
        CustomerThread ct = new CustomerThread(p);

        pt.start();
        ct.start();
    }
}
