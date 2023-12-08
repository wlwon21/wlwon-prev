// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Ji Won Kim (jiwon21)

package towerofhanoi;

import student.TestCase;

/**
 * Test class for the HanoiSolver class
 * 
 * @author Ji Won Kim
 * @version 2022.10.18
 */
public class HanoiSolverTest extends TestCase {
    private HanoiSolver hanoiSolver;
    
    /**
     * Set up for the test cases
     */
    public void setUp() {
        hanoiSolver = new HanoiSolver(2);
    }
    
    /**
     * Tests the disks() method
     */
    public void testDisks() {
        assertEquals(2, hanoiSolver.disks());
    }
    
    /**
     * Tests the getTower() method
     */
    public void testGetTower() {
        assertEquals(hanoiSolver.getTower(Position.RIGHT).position(),
            Position.RIGHT);
        assertEquals(hanoiSolver.getTower(Position.LEFT).position(),
            Position.LEFT);
        assertEquals(hanoiSolver.getTower(Position.MIDDLE).position(), 
            Position.MIDDLE);
    }
    
    /**
     * Tests the toString() method
     */
    public void testToString() {
        Disk disk = new Disk(10);
        Disk disk1 = new Disk(20);
        hanoiSolver.getTower(Position.LEFT).push(disk1);
        hanoiSolver.getTower(Position.LEFT).push(disk);
        hanoiSolver.getTower(Position.RIGHT).push(disk);
        hanoiSolver.getTower(Position.MIDDLE).push(disk1);
        assertEquals("[10, 20][20][10]", hanoiSolver.toString());
    }
    
    /**
     * Tests the solve() method
     */
    public void testSolve() {
        Disk disk = new Disk(10);
        Disk disk1 = new Disk(20);
        hanoiSolver.getTower(Position.LEFT).push(disk1);
        hanoiSolver.getTower(Position.LEFT).push(disk);
        
        assertEquals(2, hanoiSolver.getTower(Position.LEFT).size());
        hanoiSolver.solve();
        assertEquals(2, hanoiSolver.getTower(Position.RIGHT).size());
    }
}
