package utils;

import java.util.EmptyStackException;

public class ScratchStringStack {
    private int size;
    private Node first;

    public ScratchStringStack(){
        this.size = 0;
        this.first = null;
    }

    public void push(String data){
        if(data == null){
            throw new IllegalArgumentException("Nulls are not permitted in the stack");
        }

        Node newNode = new Node(data);
        newNode.next = first;
        first = newNode;
        size++;
    }

    public String pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        String removed = first.data;
        first = first.next;
        size--;
        return removed;
    }

    public String peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return first.data;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
        // return first == null;
    }

    private static class Node{
        private Node next;
        private String data;

        public Node(String data){
            this.data = data;
            this.next = null;
        }
    }
}
