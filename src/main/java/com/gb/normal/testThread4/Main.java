package com.gb.normal.testThread4;

import org.openjdk.jol.info.ClassLayout;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        User userTemp = new User();
        System.out.println("无状态(001):" + ClassLayout.parseInstance(userTemp).toPrintable());
        /*
            JVM默认4s自动开启偏向锁
         */
        Thread.sleep(5000);
        User user = new User();
        System.out.println("启动偏向锁(101):" + ClassLayout.parseInstance(user).toPrintable());
        for (int i = 0; i < 2; i++) {
            synchronized(user){
                System.out.println("偏向锁(101):(带线程id)" + ClassLayout.parseInstance(user).toPrintable());
            }
            System.out.println("偏向锁(101)释放:(带线程id)" + ClassLayout.parseInstance(user).toPrintable());
        }

        new Thread(()->{
            synchronized (user){
                System.out.println("轻量级锁(00):" + ClassLayout.parseInstance(user).toPrintable());
                try {
                    System.out.println("*****睡眠了3秒******");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("轻量-->重量(10):" + ClassLayout.parseInstance(user).toPrintable());
            }
        }).start();

        Thread.sleep(1000);
        new Thread(()->{
            synchronized (user){
                System.out.println("重量级锁(10):" + ClassLayout.parseInstance(user).toPrintable());
            }
        }).start();
    }
}
