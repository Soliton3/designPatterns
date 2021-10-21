package com.dp.visitor;

public class Computer {

    ComputerPart cpu = new Cpu();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();
    public void accept(Visitor visitor){
        this.cpu.accept(visitor);
        this.memory.accept(visitor);
        this.board.accept(visitor);
    }

    public static void main(String[] args) {
        PersonVisitor p = new PersonVisitor();
        new Computer().accept(p);
        System.out.println(p.totalPrice);
    }
}

/**
 * 私人访问者
 */
class PersonVisitor implements Visitor{
    double totalPrice = 0.0;

    @Override
    public void visitCpu(Cpu cpu) {
        totalPrice += cpu.getPrice()*0.9;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice()*0.85;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice()*0.8;
    }
}

/**
 * 公司访问者
 */
class CompanyVisitor implements Visitor{
    double totalPrice = 0.0;

    @Override
    public void visitCpu(Cpu cpu) {
        totalPrice += cpu.getPrice()*0.8;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice()*0.7;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice()*0.6;
    }
}

abstract class ComputerPart{
    abstract void accept(Visitor visitor);
    abstract double getPrice();
}

class Cpu extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}
class Memory extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 400;
    }
}
class Board extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}
interface Visitor{
    void visitCpu(Cpu cpu);
    void visitMemory(Memory memory);
    void visitBoard(Board board);
}
