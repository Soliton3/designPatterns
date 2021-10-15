package com.gb.normal;


import org.openjdk.jol.info.ClassLayout;

public class demo01 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(0).toPrintable());

        synchronized(o){
            System.out.println(ClassLayout.parseInstance(0).toPrintable());
        }
    }
}
