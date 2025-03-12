package utils;

public class BoundedLinkedList extends LinkBasedList {
    private final int maxCapacity;
    
    public BoundedLinkedList(int maxCapacity){
        if(maxCapacity <= 0){
            throw new IllegalArgumentException("Max capacity must be greater than 0.");
        }
        this.maxCapacity = maxCapacity;
    }
    
    public boolean isFull(){
        return maxCapacity == this.size();
    }

    @Override
    public void add(String value) {
        if(isFull()) {
            throw new IllegalStateException("Cannot add new element. List is already at maximum capacity.");
        }
        super.add(value);
    }

    @Override
    public void addFirst(String value) {
        if(isFull()) {
            throw new IllegalStateException("Cannot add new element. List is already at maximum capacity.");
        }
        super.addFirst(value);
    }

    @Override
    public void add(String value, int pos) {
        if(isFull()) {
            throw new IllegalStateException("Cannot add new element. List is already at maximum capacity.");
        }
        super.add(value, pos);
    }
}
