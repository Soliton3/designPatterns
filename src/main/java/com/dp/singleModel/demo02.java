package com.dp.singleModel;

/*
利用锁解决线程安全问题，但是代码较为繁琐
 */
public class demo02 {
    private static demo02 INSTANCE;
    private demo02(){};

    public static demo02 getInstance(){
        if (INSTANCE == null){
            synchronized (demo02.class){
                if (INSTANCE == null){
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    INSTANCE = new demo02();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(demo02.getInstance().hashCode());
            }).start();
        }
    }
}
