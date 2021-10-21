package com.gb.normal.testThread;

public class Test02 {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
            }
        }).start();

        new Thread(()->{
            for (int i = 20; i <= 30; i++) {
                System.out.println(i);
            }
        }).start();
    }
}
