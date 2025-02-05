package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void testIndexOf_ValueNotPresent() {
        IntDynamicArray myList = new IntDynamicArray();
        myList.add(5);
        myList.add(10);
        myList.add(15);

        int expResult = -1;
        int result = myList.indexOf(20);
        assertEquals(expResult, result, "Incorrectly located invalid value");
    }

    @Test
    public void testGet_NegativePosition() {
        IntDynamicArray myList = new IntDynamicArray();
        myList.add(5);
        myList.add(10);
        myList.add(15);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.get(-1);
        });
    }

    /*
     * Tests for size():
     *  - empty list
     *  - one element
     *  - multiple elements (no growth)
     *  - after growth (e.g. 11)
     */

    @Test
    public void testSize_EmptyList(){
        IntDynamicArray myList = new IntDynamicArray();
        int size = 0;
        assertEquals(size, myList.size(), "Newly created list did not have size 0");
    }

    /*
     * Tests for get():
     *  - get from a negative position
     *  - get from position 1 of a populated list (multiple elements in list)
     *  - get from position 0 (start position) of a populated list
     *  - get from end position of a populated list (multiple elements)
     *  - get from after the end of the list (> length)
     *  - get from position equal to length of list (== length)
     */

    @Test
    public void testAdd_EmptyList() {
        IntDynamicArray myList = new IntDynamicArray();
        int size = 0;
        assertEquals(size, myList.size(), "Newly created list did not have size 0");

        int data = 10;
        myList.add(data);
        int expSize = size + 1;
        assertEquals(expSize, myList.size(), "Size of list did not increase by 1");

        assertEquals(data, myList.get(size), "Value was not inserted at appropriate position (start)");
    }

    @Test
    public void testAdd_PopulatedList() {
        IntDynamicArray myList = new IntDynamicArray();
        int [] data = {1, 2, 3, 4, 5};

        for (int i = 0; i < data.length; i++) {
            myList.add(data[i]);
        }

        assertEquals(data.length, myList.size(), "Newly created list did not have size "+ data.length);

        int value = 10;
        myList.add(value);
        int expSize = data.length + 1;
        assertEquals(expSize, myList.size(), "Size of list did not increase by 1");

        assertEquals(value, myList.get(data.length), "Value was not inserted at appropriate position (after " +
                "original data)");

        for (int i = 0; i < data.length; i++) {
            assertEquals(data[i], myList.get(i));
        }
    }

    /*
    * Tests for add:
    *  - Adding to "full" list (triggering grow)
    */
}
