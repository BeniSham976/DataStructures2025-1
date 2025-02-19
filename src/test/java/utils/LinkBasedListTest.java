package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkBasedListTest {

    @Test
    void testSize_EmptyList() {
        // SET UP:
        LinkBasedList testList = new LinkBasedList();
        int expResult = 0;

        // LOGIC:
        int result = testList.size();

        // ASSERTIONS:
        assertEquals(expResult, result, "Size of empty list was not 0");
    }

    @Test
    void testSize_OneElement() {
        // SET UP:
        LinkBasedList testList = new LinkBasedList();
        testList.add("Name");
        int expResult = 1;

        // LOGIC:
        int result = testList.size();

        // ASSERTIONS:
        assertEquals(expResult, result, "Size of list with one element was not 1");
    }

    @Test
    void testSize_MultipleElements() {
        // SET UP:
        LinkBasedList testList = new LinkBasedList();
        String [] data = {"Name1", "Name2", "Name3", "Name4", "Name5"};
        for (String s : data) {
            testList.add(s);
        }
        int expResult = data.length;

        // LOGIC:
        int result = testList.size();

        // ASSERTIONS:
        assertEquals(expResult, result, "Size of list with "+ data.length + " elements was not " + data.length);
    }

    @Test
    void testIsEmpty_EmptyList() {
        // SET UP:
        LinkBasedList testList = new LinkBasedList();
        boolean expResult = true;

        // LOGIC:
        boolean result = testList.isEmpty();

        // ASSERTIONS:
        assertEquals(expResult, result, "isEmpty() on empty list did not return true");
    }

    @Test
    void testIsEmpty_PopulatedList() {
        // SET UP:
        LinkBasedList testList = new LinkBasedList();
        testList.add("Data");
        boolean expResult = false;

        // LOGIC:
        boolean result = testList.isEmpty();

        // ASSERTIONS:
        assertEquals(expResult, result, "isEmpty() on populated list did not return false");
    }

    @Test
    public void testAdd_EmptyList(){
        // SET UP:
        LinkBasedList testList = new LinkBasedList();
        int expSize = 1;
        String expValue = "Data";

        // LOGIC:
        testList.add(expValue);

        // ASSERTIONS:
        assertEquals(expSize, testList.size(), "Incorrect size after add to empty list");
        assertEquals(expValue, testList.get(0), "Value added to empty list could not be retrieved from position 0");
    }

    /*
     * Tests for get():
     * Invalid cases:
     *  - get from a negative position
     *  - get from after the end of the list (> length)
     *  - get from position equal to length of list (== length)
     *
     * Valid cases:
     *  - get from position 1 of a populated list (multiple elements in list)
     *  - get from position 0 (start position) of a populated list
     *  - get from end position of a populated list (multiple elements)
     */
    @Test
    public void testGet_NegativePosition() {
        LinkBasedList myList = new LinkBasedList();
        myList.add("Hi");
        myList.add("Hello");
        myList.add("Hey there");

        assertThrows(IndexOutOfBoundsException.class, () -> myList.get(-1), "IndexOutOfBoundsException not thrown when attempting to get from negative position in list");
    }

    @Test
    public void testGet_AboveBoundary_EqualToSize() {
        LinkBasedList myList = new LinkBasedList();
        myList.add("Hi");
        myList.add("Hello");
        myList.add("Hey there");

        assertThrows(IndexOutOfBoundsException.class, () -> myList.get(3), "IndexOutOfBoundsException not thrown when attempting to get from position=length of list");
    }

    @Test
    public void testGet_AboveBoundary_GreaterThanSize() {
        // "Manual" list population
        LinkBasedList myList = new LinkBasedList();
        myList.add("Hi");
        myList.add("Hello");
        myList.add("Hey there");

        assertThrows(IndexOutOfBoundsException.class, () -> myList.get(4), "IndexOutOfBoundsException not thrown when attempting to get from position > length of list");
    }

    @Test
    public void testGet_ZeroIndex_PopulatedList() {
        // "Automated" list population
        String [] sourceData = {"Hi", "Hello", "Hey there"};
        LinkBasedList myList = new LinkBasedList();
        for(int i = 0; i < sourceData.length; i++){
            myList.add(sourceData[i]);
        }

        int pos = 0;
        String expResult = sourceData[pos];
        String result = myList.get(pos);
        assertEquals(expResult, result, "Value not found at position "+pos + ".");
    }

    @Test
    public void testGet_LastElement_PopulatedList() {
        String [] sourceData = {"Hi", "Hello", "Hey there"};
        LinkBasedList myList = new LinkBasedList();
        for(int i = 0; i < sourceData.length; i++){
            myList.add(sourceData[i]);
        }

        int pos = sourceData.length-1;
        String expResult = sourceData[pos];
        String result = myList.get(pos);
        assertEquals(expResult, result, "Value not found at position " + pos + " (last position in list).");
    }

    @Test
    public void testGet_ElementInPopulatedList() {
        String [] sourceData = {"Hi", "Hello", "Hey there"};
        LinkBasedList myList = new LinkBasedList();
        for(int i = 0; i < sourceData.length; i++){
            myList.add(sourceData[i]);
        }

        int pos = sourceData.length/2;
        String expResult = sourceData[pos];
        String result = myList.get(pos);
        assertEquals(expResult, result, "Value not found at position " + pos + " (position within bounds of list).");
    }
}