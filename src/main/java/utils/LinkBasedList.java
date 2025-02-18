package utils;

public class LinkBasedList {
    private int numElements;

    private Node first;
    private Node last;

    public LinkBasedList(){
        this.first = null;
        this.last = null;
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
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }

        numElements++;
    }


    public void addFirst(String value){
        // VALIDATION:
        // Nulls are not permitted - throw exception if one is provided
        if(value == null){
            throw new IllegalArgumentException("List cannot handle null elements.");
        }

        // SETUP:
        // Wrap value in a node so it can be added to the list
        Node newNode = new Node(value);
        // LOGIC:
        // If list is currently empty, the new node should be the first and last element
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            // Put the new node in front of the current first element
            newNode.next = first;
            // Set the new node as the official start of the list
            first = newNode;
        }
        // Increase the number of elements in the list
        numElements++;
    }


    public int indexOf(String value){
        // VALIDATION:
        // Nulls are not permitted - throw exception if one is provided
        if(value == null){
            throw new IllegalArgumentException("List cannot handle null elements.");
        }

        // SETUP:
        // Create a node to track progress in list and point it at the first thing in the list
        // This will let us move through the list, accessing each node in order
        Node current = first;
        // Loop to the end of the list
        for(int i = 0; i < numElements; i++){
            // Check if the current node contains the data being looked for
            if(value.equalsIgnoreCase(current.data)){
                // If so, return this node's position in the list
                return i;
            }
            // If it doesn't match, move our tracker node on to the next position in the list
            current = current.next;
        }
        // No match found, return -1
        return -1;
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
