package com.dp.observer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestFrame extends Frame {

    public void launch(){
        Button b = new Button("press me");
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        this.add(b);
        this.pack();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);//退出系统
            }
        });
        this.setLocation(100,100);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TestFrame().launch();
    }
    private static class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed!");
        }
    }
    private static class MyActionListener2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed 2!");
        }
    }
}
