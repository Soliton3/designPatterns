package com.dp.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * 利用cglib生成代理（动态代理）,不需要生成接口
 */
public class Demo3 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodIntercept());
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}

class TimeMethodIntercept implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object result = null;
        result = methodProxy.invokeSuper(o,objects);
        System.out.println("after");
        return result;
    }
}

class Tank{
    public void move() {
        System.out.println("do something...");
        try{
            Thread.sleep(new Random().nextInt(10000));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}