package com.dp.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * 利用jdk实现动态代理
 */
public class Demo2 implements Movable{
    @Override
    public void move() {
        System.out.println("do something...");
        try{
            Thread.sleep(new Random().nextInt(10000));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();

        Movable m = (Movable) Proxy.newProxyInstance(Demo2.class.getClassLoader(),
                new Class[]{Movable.class},
                new logHandler(demo2));
        m.move();
    }
}

class logHandler implements InvocationHandler{

    Demo2 d;

    public logHandler(Demo2 d) {
        this.d = d;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method " + method.getName() + " start..");
        Object o = method.invoke(d,args);
        System.out.println("method " + method.getName() + " end..");
        return o;
    }
}
