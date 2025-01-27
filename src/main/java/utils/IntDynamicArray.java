package utils;

public class IntDynamicArray {
    private int [] data;
    private int numElements;

    public IntDynamicArray(){
        this(10);
    }

    public IntDynamicArray(int startSize){
        if(startSize <= 0){
            throw new IllegalArgumentException("Internal array size cannot be less than 1");
        }
        data = new int[startSize];
    }


}
