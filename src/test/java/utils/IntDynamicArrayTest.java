package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntDynamicArrayTest {
    @Test
    public void testIndexOf_ValuePresent() {
        IntDynamicArray myList = new IntDynamicArray();
        myList.add(5);
        myList.add(10);
        myList.add(15);

        int expResult = 1;
        int result = myList.indexOf(10);
        assertEquals(expResult, result, "Failed on locating valid value");
    }

    @Test
    public void testIndexOf_ValueNotPresent(){
        IntDynamicArray myList = new IntDynamicArray();
        myList.add(5);
        myList.add(10);
        myList.add(15);

        int expResult = -1;
        int result = myList.indexOf(20);
        assertEquals(expResult, result, "Incorrectly located invalid value");
    }

    @Test
    public void testGet_NegativePosition(){
        IntDynamicArray myList = new IntDynamicArray():
        myList.add(5);
        myList.add(10);
        myList.add(15);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.get(-1);
        });
    }
}
