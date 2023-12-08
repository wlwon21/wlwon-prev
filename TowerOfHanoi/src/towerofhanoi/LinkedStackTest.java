// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Ji Won Kim (jiwon21)

package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * Test class for the LinkedStack class
 * 
 * @author Ji Won Kim
 * @version 2022.10.18
 */
public class LinkedStackTest extends TestCase {
    private LinkedStack<String> string;
    
    /**
     * The set up for the test cases
     */
    public void setUp() {
        string = new LinkedStack<>();
    }
    
    /**
     * Tests the size() method
     */
    public void testSize() {
        assertEquals(0, string.size());
        string.push("test");
        assertEquals(1, string.size());
    }
    
    /**
     * Tests the clear() method
     */
    public void testClear() {
        string.push("test");
        string.push("test1");
        assertEquals(2, string.size());
        string.clear();
        assertEquals(0, string.size());
    }
    
    /**
     * Tests the isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(string.isEmpty());
        string.push("test");
        assertFalse(string.isEmpty());
    }
    
    /**
     * Tests the peek() method
     */
    public void testPeek() {
        Exception exception = null;
        try {
            string.peek();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof EmptyStackException);
        string.push("test");
        assertEquals("test", string.peek());
    }
    
    /**
     * Tests the pop() method
     */
    public void testPop() {
        Exception exception = null;
        try {
            string.pop();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof EmptyStackException);
        string.push("test");
        string.push("test1");
        assertEquals(2, string.size());
        assertEquals("test1", string.pop());
        assertEquals(1, string.size());
    }
    
    /**
     * Tests the push() method
     */
    public void testPush() {
        assertEquals(0, string.size());
        string.push("test");
        assertEquals(1, string.size());
        assertEquals("test", string.peek());
    }
    
    /**
     * Tests the toString() method
     */
    public void testToString() {
        assertEquals("[]", string.toString());
        string.push("test");
        string.push("test2");
        assertEquals("[test2, test]", string.toString());
    }
}
