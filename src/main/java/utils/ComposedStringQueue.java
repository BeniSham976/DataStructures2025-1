package utils;

import java.util.NoSuchElementException;

public class ComposedStringQueue {
    private LinkBasedList list;

    public ComposedStringQueue(){
        list = new LinkBasedList();
    }

    // QUEUE ADT:
    // Add to end
    public void add(String value){
        if(value == null){
            throw new IllegalArgumentException("Queue cannot hold nulls");
        }

        list.add(value);
    }

    // Remove from start
    public String remove(){
        if(list.isEmpty()){
            throw new NoSuchElementException("Cannot remove from an empty Queue");
        }

        return list.remove(0);
    }

    // Peek (get element at start)
    public String peek(){
        if(list.isEmpty()){
            throw new NoSuchElementException("Cannot retrieve from an empty Queue");
        }

        return list.get(0);
    }

    // Get size
    public int size(){
        return list.size();
    }

    // Check if empty
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
