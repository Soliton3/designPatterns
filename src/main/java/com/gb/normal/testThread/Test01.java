package com.gb.normal.testThread;

public class Test01 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("----子线程:"+i);
        }
    }
}
class Test{
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            System.out.println("主线程:"+i);
            if (i == 6){
                Test01 t1 = new Test01();
                Thread t2 = new Thread(t1);
                t2.start();
                t2.join();
            }
        }

    }
}
