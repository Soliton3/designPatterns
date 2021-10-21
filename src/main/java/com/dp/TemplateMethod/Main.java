package com.dp.TemplateMethod;

public class Main {
    public static void main(String[] args) {
        Father s = new Son();
        s.m();
    }
}

abstract class Father{
    public void m(){
        op1();
        op2();
    }
    abstract void op1();
    abstract void op2();
}
class Son extends Father{

    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }
}