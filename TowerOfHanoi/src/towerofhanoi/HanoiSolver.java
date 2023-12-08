// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Ji Won Kim (jiwon21)

package towerofhanoi;

import java.util.Observable;

/**
 * This class will solve the Tower of Hanoi
 * 
 * @author Ji Won Kim
 * @version 2022.10.18
 */
@SuppressWarnings("deprecation")
public class HanoiSolver extends Observable {
    
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;
    
    /**
     * The constructor for the class
     * 
     * @param disks number of disks
     */
    public HanoiSolver(int disks) {
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
        this.numDisks = disks;
    }
    
    /**
     * Returns the number of disks
     * 
     * @return the number of disks
     */
    public int disks() {
        return numDisks;
    }
    
    /**
     * Returns the tower depending on the position requested
     * 
     * @param pos the position
     * @return the tower in that position
     */
    public Tower getTower(Position pos) {
        if (pos == Position.LEFT) {
            return left;
        }
        else if (pos == Position.RIGHT) {
            return right;
        }
        return middle;
    }
    
    /**
     * Returns the left middle and right as string 
     * 
     * @return returns the string in left, middle, right
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(left.toString());
        string.append(middle.toString());
        string.append(right.toString());
        
        return string.toString();
    }

    /**
     * Moves the disks to the other towers
     * 
     * @param source The tower the disk starts at
     * @param destination The tower the disk will be moved to
     */
    private void move(Tower source, Tower destination) {
        Disk disk = source.pop();
        destination.push(disk);
        setChanged();
        notifyObservers(destination.position());
    }
    
    /**
     * Solves the tower 
     * 
     * @param currentDisks the number of disks in the tower
     * @param startPole the tower the disks starts at
     * @param tempPole the temporary pole the disks would be at
     * @param endPole the end pole that the disks would be moved to
     */
    private void solveTowers(int currentDisks, Tower startPole, 
        Tower tempPole, Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }
    
    /**
     * Uses the solveTower recursion to solve the tower of hanoi
     */
    public void solve() {
        solveTowers(numDisks, left, middle, right);
    }
}
