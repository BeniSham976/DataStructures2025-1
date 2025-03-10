package utils;

import exceptions.DuplicateElementException;

public class StringLinkedListSet {
    // Metadata to track how many elements are in the list
    private int numElements;

    // Pointers to find the start and end of the list
    private Node first;
    private Node last;

    /**
     * No-argument constructor initialising the list to default settings.
     */
    public StringLinkedListSet(){
        this.first = null;
        this.last = null;
        this.numElements = 0;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    public int size(){
        return numElements;
    }

    /**
     * Returns true if this list contains no elements.
     * @return True if this list contains no elements, false otherwise
     */
    public boolean isEmpty(){
        return numElements == 0;
        // Could also use this condition:
        // return first == null;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= numElements) or the list
     * is empty
     */
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

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     * @param value the element to search for
     * @return the index of the first occurrence of the element, or -1 if this list does not contain the element
     * @throws IllegalArgumentException if the value to be found is null
     */
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

    /**
     * Add the specified element to the end of this list.
     * @param value the element to be added to this list
     * @throws IllegalArgumentException if the value to be added is null
     */
    public void add(String value){
        // VALIDATION
        if(value == null){
            throw new IllegalArgumentException("Null cannot be added to set");
        }

        int present = indexOf(value);
        if(present != -1){
            throw new DuplicateElementException("Element already exists in set");
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

    public void add(String value, int pos){
        // VALIDATION:
        // Nulls are not permitted - throw exception if one is provided
        if(value == null){
            throw new IllegalArgumentException("List cannot handle null elements.");
        }

        if(pos < 0 || pos > numElements){
            throw new IndexOutOfBoundsException("Index must be between 0 and " + numElements + " inclusive. (Supplied" +
                    " index was" +
                    " " + pos+")");
        }

        if(pos == 0){
            addFirst(value);
        }else if(pos == size()){
            add(value);
        }else{
            Node newNode = new Node(value);

            Node current = first;
            for(int i = 0; i < pos-1; i++){
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;

            numElements++;
        }
    }

    /**
     * Add the specified element to the start of this list.
     * @param value the element to be added to this list
     * @throws IllegalArgumentException if the value to be added is null
     */
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

    // Remove from list:
    public void remove(int pos){
        // Validation
        if(isEmpty() || pos < 0 || pos >= numElements){
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (numElements-1) + " inclusive. " +
                    "(Supplied" +
                    " index was" +
                    " " + pos+")");
        }

        // Remove from start of list
        // If position to remove from is 0 (i.e. start of list)
        if(pos == 0){
            // Snip off/jump over first element in list
            first = first.next;
            // If the list is now empty (i.e. there was only one element in the list before we did the remove)
            if(first == null){
                // Wipe last node too
                last = null;
            }
        }else {
            // Create current node to track our current position in list (Tomasz in class example)
            Node current = first;
            // Create prev node to track the position of the node before us (Bema in class example)
            Node prev = null;

            // Loop up to position from which we should remove
            for(int i = 0; i < pos; i++){
                prev = current;
                current = current.next;
            }
            // "Snip" node to be removed from list
            // This will make the node before us (Bema) point to the node after us (Oscar),
            // essentially routing the list around us (Tomasz) and ignoring us entirely
            prev.next = current.next;
            // Remove our link to the list so we know we're not in it anymore
            current.next = null;
            // If there is nothing after prev (i.e. we've reached the end of the list)
            if(prev.next == null){
                // Call this element the new end of the list
                last = prev;
            }
        }
        // Decrease the number of elements in the list as one has been removed
        numElements--;
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