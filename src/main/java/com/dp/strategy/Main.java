package com.dp.strategy;

import java.util.Arrays;

/*
功能主类，主要是比较大小
 */
public class Main {
    public static void main(String[] args) {
        Cat[] a = {new Cat(5,5),new Cat(2,2),new Cat(4,4)};
        Sorter sorter = new Sorter();
//        sorter.sort(a,new CatWeight());

        sorter.sort(a,new CatHeight());
        System.out.println(Arrays.toString(a));
    }
}
