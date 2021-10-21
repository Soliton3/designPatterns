package com.gb.normal.testThread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreatByCallable implements Callable<Integer> {
    /**
     * 实现Callable接口，如果不带泛型，那么call方法返回的就是Object对象，如果带有则返回泛型对象
     * 方法有返回值，可以抛出异常
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(10);
    }
}
class TestDemo{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //定义一个线程对象
        CreatByCallable ct = new CreatByCallable();
        FutureTask ft = new FutureTask(ct);
        Thread t = new Thread(ft);
        t.start();
        //获取线程返回值
        Object o = ft.get();
        System.out.println(o);
    }
}
