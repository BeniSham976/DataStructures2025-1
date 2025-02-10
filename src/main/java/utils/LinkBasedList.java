package utils;

public class LinkBasedList {
    private int numElements;

    private Node first;

    public LinkBasedList(){
        this.first = null;
        this.numElements = 0;
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
}
