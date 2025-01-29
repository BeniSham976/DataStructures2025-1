package utils;

public class IntDynamicArray {
    private final static int RESIZE_FACTOR = 2;

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

    private void grow(){
        int [] newArray = new int[data.length * RESIZE_FACTOR];
        System.arraycopy(data, 0, newArray, 0, data.length);

        data = newArray;
    }

    public int size(){
        return numElements;
    }

    public void add(int value){
        if(numElements == data.length){
            grow();
        }

        data[numElements++] = value;
        for (int i = 0; i < numElements; i++) {
            System.out.println(i+ ") " + data[i]);
        }
    }

    public int indexOf(int value){
        for (int i = 0; i < numElements; i++) {
            if(value == data[i]){
                return i;
            }
        }
        return -1;
    }

    public int get(int pos){
        if(pos >= numElements || pos < 0){
            throw new IndexOutOfBoundsException("Index cannot be outside the range of the data");
        }

        return data[pos];
    }
}
