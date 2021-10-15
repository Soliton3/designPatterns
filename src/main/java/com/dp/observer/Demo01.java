package com.dp.observer;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
/*
很多时候观察者需要根据事件的具体情况来进行处理
大多数时候我们处理事件的时候，需要事件源对象
 */
class Child{
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new GrandMother());
        observers.add((e)->{
            System.out.println("aaaa");
        });
    }
    public boolean isCry(){
        return cry;
    }
    public void wakeUp(){
        cry = true;
        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(),"bed",this);

        for (Observer ob : observers){
            ob.actionOnwakeUp(event);
        }
    }

}
abstract class Event<T>{
    abstract T getSource();
}

//事件类 fire event
class wakeUpEvent extends Event<Child>{
    long timeStamp;
    String loc;
    Child source;

    public wakeUpEvent(long timeStamp, String loc,Child source) {
        this.timeStamp = timeStamp;
        this.loc = loc;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}
interface Observer{
    void actionOnwakeUp(wakeUpEvent event);
}

class Dad implements Observer{

    public void feed(){
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnwakeUp(wakeUpEvent event) {
        feed();
    }
}
class Mum implements Observer{

    public void hug(){
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnwakeUp(wakeUpEvent event) {
        hug();
    }
}
class GrandMother implements Observer{

    public void feed(){
        System.out.println("grandmother feeding...");
    }

    @Override
    public void actionOnwakeUp(wakeUpEvent event) {
        feed();
    }
}