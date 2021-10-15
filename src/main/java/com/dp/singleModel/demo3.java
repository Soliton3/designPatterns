package com.dp.singleModel;

/*
采用枚举的方式实现，可以防止反序列化
 */
public enum demo3 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(demo3.INSTANCE.hashCode());
            }).start();
        }
    }
}
