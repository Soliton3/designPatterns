package com.gb.normal.testThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BuyTicket {
    public static void main(String[] args) {
        BuyThread thread = new BuyThread();

        Thread t1 = new Thread(thread,"窗口1");
        t1.start();

        Thread t2 = new Thread(thread,"窗口2");
        t2.start();

        Thread t3 = new Thread(thread,"窗口3");
        t3.start();
    }
}
class BuyThread implements Runnable{
    int ticketNum = 10;
    //拿到一把锁
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            lock.lock();
            try {
                if (ticketNum > 0){
                    System.out.println("我在"+Thread.currentThread().getName()+"买到了第"+ticketNum--+"张车票");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
