package utils;

public class StringQueue extends LinkBasedList{
    @Override
    public void addFirst(String value) {
        throw new UnsupportedOperationException("Cannot add to the start of Queue");
    }

    @Override
    public void add(String value, int pos) {
        throw new UnsupportedOperationException("Cannot add to a specified position of Queue");
    }

    @Override
    public int indexOf(String value) {
        throw new UnsupportedOperationException("Cannot search the contents of Queue");
    }

    @Override
    public String remove(int pos) {
        throw new UnsupportedOperationException("Cannot remove from specified position in Queue");
    }

    public String peek(){
        if(isEmpty()){
            throw new IllegalStateException("Cannot retrieve from an empty Queue");
        }
        return super.get(0);
    }

    public String remove(){
        if(isEmpty()){
            throw new IllegalStateException("Cannot retrieve from an empty Queue");
        }

        return super.remove(0);
    }


}
