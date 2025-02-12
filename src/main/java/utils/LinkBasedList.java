package utils;

public class LinkBasedList {
    private int numElements;

    private Node first;

    public LinkBasedList(){
        this.first = null;
        this.numElements = 0;
    }

    public int size(){
        return numElements;
    }

    public boolean isEmpty(){
        return numElements == 0;
        // Could also use this condition:
        // return first == null;
    }

    public String get(int index){
        // VALIDATION:
        if(isEmpty() || index < 0 || index >= numElements){
            throw new IndexOutOfBoundsException("Index must be between 0 and " + numElements + ". (Supplied index was" +
                    " " + index+")");
        }

        // SET UP:
        Node current = first;
        for(int i = 0; i < index; i++){
            current = current.next;
        }

        return current.data;
    }

    public void add(String value){
        // VALIDATION
        if(value == null){
            throw new IllegalArgumentException("Null cannot be added to list");
        }
        // SET UP:
        // Wrap incoming data in node
        Node newNode = new Node(value);

        // LOGIC:
        // Deal with adding first element to list
        // If the list does not already have a value / is empty
        if(first == null){
            // Set the first element in the list to be the new node
            first = newNode;
        }else{
            Node current = first;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }

        numElements++;
    }

    private static class Node{
        private String data;
        private Node next;

        public Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    /*
            int count = 0;
        Node current = first;
        while (current != null){
            count++;
            current = current.next;
        }

        return count;
     */
}
