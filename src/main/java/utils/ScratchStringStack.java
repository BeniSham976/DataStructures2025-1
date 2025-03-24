package utils;

public class ScratchStringStack {
    private int count;
    private Node first;

    public ScratchStringStack(){
        this.count = 0;
        this.first = null;
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
