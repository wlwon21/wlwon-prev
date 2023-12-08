// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Ji Won Kim (jiwon21)

package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * The Window of the Tower of Hanoi
 * 
 * @author Ji Won Kim
 * @version 2022.10.18
 */
public class PuzzleWindow implements Observer{

    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window; 
    
    private static final int WIDTH_FACTOR = 5;
    private static final int DISK_GAP = 0;
    private static final int DISK_HEIGHT = 10;
    
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }
    
    /**
     * Moves the disk to different towers
     * 
     * @param position moves the disk in that position
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;
        if (position == Position.LEFT) {
            currentPole = left;
        }
        else if (position == Position.RIGHT) {
            currentPole = right;
        }
        else {
            currentPole = middle;
        }
        int towerSize = this.game.getTower(position).size();
        int x = currentPole.getX();
        int y = currentPole.getY() + 200 - (towerSize * 10);
        
        currentDisk.moveTo(x - (currentDisk.getWidth() - WIDTH_FACTOR)/2, 
            y - DISK_GAP);
    }
    
    /**
     * The constructor of the class 
     * 
     * @param game the HanoiSolver
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        this.window = new Window("Tower of Hanoi");
        this.left = new Shape(100, 100, 5, 200, Color.BLUE);
        this.middle = new Shape(300, 100, 5, 200, Color.BLUE);
        this.right = new Shape(500, 100, 5, 200, Color.BLUE);
        
        for (int i = game.disks(); i > 0; i--) {
            Disk disk = new Disk(10 * i);
            window.addShape(disk);
            game.getTower(Position.LEFT).push(disk);
            moveDisk(Position.LEFT);
        }
        
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        Button solve = new Button("solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");
    }

    /**
     * Solve the puzzle when the button is clicked
     * @param button the button that will be clicked
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
    
    /**
     * Updates the position automatically
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass().equals(Position.class)) {
            moveDisk((Position)arg);
            sleep();
        }
    }
}
