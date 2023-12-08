// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- Ji Won Kim (jiwon21)

package towerofhanoi;

/**
 * The project runner class that will run the project
 * 
 * @author Ji Won Kim
 * @version 2022.10.18
 */
public class ProjectRunner {

    /**
     * The main method that will run the project
     * 
     * @param args
     */
    public static void main(String[] args) {
        int disks = 7;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver hanoi = new HanoiSolver(disks);
        PuzzleWindow puzzle = new PuzzleWindow(hanoi);
    }
}
