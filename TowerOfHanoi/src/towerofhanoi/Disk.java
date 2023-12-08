// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Ji Won Kim (jiwon21)

package towerofhanoi;

import cs2.Shape;
import java.awt.Color;
import student.TestableRandom;

/**
 * Makes the disks that will be on the tower
 * 
 * @author Ji Won Kim
 * @version 2022.10.17
 */
public class Disk extends Shape implements Comparable<Disk> {
    
    /**
     * Constructor of this class
     * @param width the width of the disk
     */
    public Disk(int width) {
        super(0, 0, width, 10);
        TestableRandom random = new TestableRandom();
        Color color = new Color(random.nextInt(255), random.nextInt(255)
            , random.nextInt(255));
        this.setBackgroundColor(color);
    }

    /**
     * Compares the width of this disk and the parameter disk
     * 
     * @throws IllegalArgumentException if the otherDisk is null
     * @return negative when other disk is greater, positive when opposite,
     *          0 when width is the same
     */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        if (otherDisk.getWidth() > this.getWidth()) {
            return -1;
        }
        else if (otherDisk.getWidth() == this.getWidth())
        {
            return 0;
        }
        return 1;
    }
    
    /**
     * Returns the width of the disk
     * 
     * @return returns the width of the disk as a string
     */
    public String toString() {
        return String.valueOf(this.getWidth());
    }
    
    /**
     * Checks if the obj is equal to the disk
     * 
     * @return returns true when the obj is equal to the disk
     * @param obj the object that will be compared
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        return this.getWidth() == ((Disk)obj).getWidth();
    }
}
