package com.dp.Iterator;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList_ list = new LinkedList_();

        for (int i = 0; i < 15; i++) {
            list.add("task " + i);
        }
        System.out.println(list.size());

        Iterator_ iterator = list.iteRator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        LinkedList a  = new LinkedList();
        Iterator i = a.iterator();
        i.next();
        i.hasNext();

    }
}
