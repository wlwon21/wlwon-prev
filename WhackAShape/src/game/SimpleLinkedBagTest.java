// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
// nor will I accept the actions of those who do.
// -- Ji Won Kim (jiwon21)


package game;
import student.TestCase;
import student.TestableRandom;

/**
 * Test classes for the SimpleLinkedBag class
 * 
 * @author Ji Won Kim
 * @version 2022.10.02
 */
public class SimpleLinkedBagTest extends TestCase {
    
    private SimpleLinkedBag<String> bag;
    
    /**
     * Set up for the test cases
     */
    public void setUp() {
        bag = new SimpleLinkedBag<String>();
    }
    
    /**
     * Tests the add() method
     */
    public void testAdd() {
        assertFalse(bag.add(null));
        assertTrue(bag.add("a"));
        assertEquals(1, bag.getCurrentSize());
    }
    
    /**
     * Tests the currentSize() method
     */
    public void testCurrentSize() {
        assertEquals(0, bag.getCurrentSize());
        bag.add("a");
        assertEquals(1, bag.getCurrentSize());
    }
    
    /**
     * Tests the isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(bag.isEmpty());
        bag.add("a");
        assertFalse(bag.isEmpty());
    }
    
    /**
     * Tests the pick() method
     */
    public void testPick() {
        TestableRandom.setNextInts(0, 2, 9);
        assertNull(bag.pick());
        for (int i = 0; i < 10; i++) {
            bag.add("test " + i);
        }
        assertEquals("test 9", bag.pick());
        assertEquals("test 7", bag.pick());
        assertEquals("test 0", bag.pick());
    }
    
    /**
     * Tests the remove() method
     */
    public void testRemove() {
        assertFalse(bag.remove(null));
        bag.add("test2");
        bag.add("test");
        assertEquals(2, bag.getCurrentSize());
        assertTrue(bag.remove("test"));
        assertEquals(1, bag.getCurrentSize());
        assertFalse(bag.remove("test3"));
        assertTrue(bag.remove("test2"));
    }
}
