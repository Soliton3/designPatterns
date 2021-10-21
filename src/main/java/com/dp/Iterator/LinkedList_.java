package com.dp.Iterator;


import java.util.Objects;

public class LinkedList_ implements Collection_ {

    Node head = null;
    Node tail = null;

    private int size = 0;
    @Override
    public void add(Object o) {
        Node node = new Node(o);
        node.next = null;

        if (head == null){
            head = node;
            tail = node;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator_ iteRator() {
        return null;
    }
    private class Node{
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

    private class LinkedListIterator implements Iterator_{
        private Node currentIndex = head;

        @Override
        public boolean hasNext() {
            if (currentIndex.next == null)
                return false;
            return true;
        }

        @Override
        public Object next() {
            Object o = currentIndex.o;
            currentIndex = currentIndex.next;
            return o;
        }
    }
}
