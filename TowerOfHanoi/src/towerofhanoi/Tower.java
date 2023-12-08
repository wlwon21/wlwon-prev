// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Ji Won Kim (jiwon21)

package towerofhanoi;

/**
 * The class for the tower that extends the LinkedStack<Disk> class
 * 
 * @author Ji Won Kim
 * @version 2022.10.18
 */
public class Tower extends LinkedStack<Disk> {
    private Position position;
    
    /**
     * The constructor for the class
     * 
     * @param position position of the tower
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }
    
    /**
     * Returns the position of the tower
     * @return position of the tower
     */
    public Position position() {
        return position;
    }
    
    /**
     * Pushes the disk to the tower
     * 
     * @throws IllegalArgumentException the disk is null
     * @throws IllegalStateException invalid push
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty() || peek().compareTo(disk) > 0)
        {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }
}
