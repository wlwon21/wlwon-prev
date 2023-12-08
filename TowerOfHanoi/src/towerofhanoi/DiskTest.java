// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Ji Won Kim (jiwon21)

package towerofhanoi;

import student.TestCase;

/**
 * Test cases for the Disk class
 * 
 * @author Ji Won Kim
 * @version 2022.10.18
 */
public class DiskTest extends TestCase {
    private Disk disk;
    private Disk disk1;
    private Disk disk2;
    
    /**
     * set up for the test cases
     */
    public void setUp() {
        disk = new Disk(10);
        disk1 = new Disk(15);
        disk2 = new Disk(5);
    }
    
    /**
     * Tests the compareTo() method
     */
    public void testCompareTo() {
        Disk nullDisk = null;
        Exception exception = null;
        try {
            disk.compareTo(nullDisk);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
        assertEquals(-1, disk.compareTo(disk1));
        assertEquals(1, disk.compareTo(disk2));
        assertEquals(0, disk.compareTo(disk));
    }
    
    /**
     * Tests the toString() method
     */
    public void testToString() {
        assertEquals("10", disk.toString());
    }
    
    /**
     * Tests the equals() method
     */
    public void testEquals() {
        Disk nullDisk = null;
        Disk sameDisk = new Disk(10);
        Object notDisk = new Object();
        assertTrue(disk.equals(disk));
        assertTrue(disk.equals(sameDisk));
        assertFalse(disk.equals(nullDisk));
        assertFalse(disk.equals(disk1));
        assertFalse(disk.equals(notDisk));
        
    }
}
