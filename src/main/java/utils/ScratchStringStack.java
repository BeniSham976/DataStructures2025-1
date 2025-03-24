package utils;

public class ScratchStringStack {
    private int size;
    private Node first;

    public ScratchStringStack(){
        this.size = 0;
        this.first = null;
    }

    // TODO: push()
    // TODO: pop()
    // TODO: peek()

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
