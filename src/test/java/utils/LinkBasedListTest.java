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
    void isEmpty() {
    }
}