package exercises;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestLinkedList {
    @Test
    public void testAddSingleElement() {
        LinkedList list = new LinkedList();
        list.add(5);
        int result = list.get(0);
        assertEquals(5, result);
    }

    @Test
    public void testAddTwoElements() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(2);
        int result = list.get(0);
        assertEquals(5, result);
    }

    @Test
    public void testAddTwoElementsAndGetSecond() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(2);
        int result = list.get(1);
        assertEquals(2, result);
    }

    @Test
    public void testAddSingleElementAndGetSecond() {
        LinkedList list = new LinkedList();
        list.add(5);
        boolean success = false;
        try {
            int result = list.get(1);
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }
        assertEquals(true, success);
    }

    @Test
    public void testGetWithNegativeIndex() {
        LinkedList list = new LinkedList();
        list.add(5);
        boolean success = false;
        try {
            int result = list.get(-1);
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }
        assertEquals(true, success);
    }

    @Test
    public void testSizeWithEmptyList() {
        LinkedList list = new LinkedList();
        int result = list.size();
        assertEquals(0, result);
    }

    @Test
    public void testSizeWithSingletonList() {
        LinkedList list = new LinkedList();
        list.add(5);
        int result = list.size();
        assertEquals(1, result);
    }

    @Test
    public void testSizeWithNonEmptyList() {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(12);
        int result = list.size();
        assertEquals(4, result);
    }
}
