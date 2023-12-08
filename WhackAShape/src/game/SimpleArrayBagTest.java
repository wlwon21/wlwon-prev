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
 * Test class for the SimpleArrayBag<T> class
 * 
 * @author Ji Won Kim
 * @version 2022.10.02
 *
 */
public class SimpleArrayBagTest extends TestCase {

    private SimpleArrayBag<String> bag;
    
    /**
     * Set up for the test cases
     */
    public void setUp() {
        bag = new SimpleArrayBag<String>();
    }
    
    /**
     * The test case for the getCurrentSize() method
     */
    public void testGetCurrentSize() {
        assertEquals(0, bag.getCurrentSize());
        bag.add("");
        assertEquals(1, bag.getCurrentSize());
    }
    
    /**
     * Test case for the isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(bag.isEmpty());
        bag.add("");
        assertFalse(bag.isEmpty());
    }
    
    /**
     * Test case for the add() method
     */
    public void testAdd() {
        String a = null;
        assertFalse(bag.add(a));
        for (int i = 0; i < 17; i++) {
            bag.add("a" + i);
        }
        assertTrue(bag.add("b"));
        assertFalse(bag.add("c"));
    }
    
    /**
     * Test case for the pick() method
     */
    public void testPick() {
        TestableRandom.setNextInts(0, 3, 17);
        assertNull(bag.pick());
        for (int i = 0; i < 18; i++) {
            bag.add("a" + i);
        }
        assertEquals("a0", bag.pick());
        assertEquals("a3", bag.pick());
        assertEquals("a17", bag.pick());
    }
    
    /**
     * Test case for the remove() method
     */
    public void testRemove() {
        for (int i = 0; i < 10; i++) {
            bag.add("a" + i);
        }
        assertEquals(10, bag.getCurrentSize());
        assertFalse(bag.remove("b"));
        assertTrue(bag.remove("a7"));
        assertEquals(9, bag.getCurrentSize());
    }
}
