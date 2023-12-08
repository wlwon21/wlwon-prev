// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Ji Won Kim (jiwon21)

package towerofhanoi;

import student.TestCase;

/**
 * Tests the Tower Class
 * 
 * @author Ji Won Kim
 * @version 2022.10.18
 */
public class TowerTest extends TestCase {

    private Tower tower;
    
    /**
     * Set up for the test cases
     */
    public void setUp() {
        tower = new Tower(Position.LEFT);
    }
    
    /**
     * Tests the position() method;
     */
    public void testPosition() {
        assertEquals(Position.LEFT, tower.position());
    }
    
    /**
     * Tests the push() method
     */
    public void testPush() {
        Disk disk = new Disk(5);
        Disk disk1 = new Disk(10);
        Disk nullDisk = null;
        Exception exception = null;
        try {
            tower.push(nullDisk);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
        tower.push(disk);
        assertEquals(1, tower.size());
        Exception ex = null;
        try {
            tower.push(disk1);
        }
        catch (Exception e) {
            ex = e;
        }
        assertNotNull(ex);
        assertTrue(ex instanceof IllegalStateException);
    }
}
