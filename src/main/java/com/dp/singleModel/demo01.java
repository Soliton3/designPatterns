package com.dp.singleModel;
/*
优点：常用的单例模式方法，利用jvm保证了线程安全问题。
缺点：运行就创建的实例，有可能不需要用到
 */
public class demo01 {
    private static final demo01 INSTANCE = new demo01();
    private demo01(){};

    public static demo01 getInstance(){
        try {
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("开始工作……");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
//                demo01.getInstance().m();
                System.out.println(demo01.getInstance().hashCode());
            }).start();
        }
    }
}
