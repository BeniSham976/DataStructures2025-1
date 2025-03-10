package utils;

import exceptions.DuplicateElementException;

public class InheritedStringListSet extends LinkBasedList{
    @Override
    public void add(String value){
        if(value == null){
            throw new IllegalArgumentException("Nulls cannot be added to the set");
        }
        
        blockDuplicates(value);
        super.add(value);
    }

    @Override
    public void add(String value, int pos){
        if(value == null){
            throw new IllegalArgumentException("Nulls cannot be added to the set");
        }

        blockDuplicates(value);
        super.add(value, pos);
    }


    @Override
    public void addFirst(String value){
        if(value == null){
            throw new IllegalArgumentException("Nulls cannot be added to the set");
        }

        blockDuplicates(value);
        super.addFirst(value);
    }
    
    private void blockDuplicates(String value) {
        int present = indexOf(value);
        if(present != -1){
            throw new DuplicateElementException("Element already exists in set");
        }
    }
}
