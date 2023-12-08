// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
// nor will I accept the actions of those who do.
// -- Ji Won Kim (jiwon21)

package game;

/**
 * @author Ji Won Kim
 * @version 2022.10.02
 *
 */
public class ProjectRunner {
    
    /**
     * The main method of ProjectRunner
     * 
     * @param args Array of strings
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            WhackAShape whack = new WhackAShape(args);
        }
        else {
            WhackAShape whack = new WhackAShape();
        }
    }
}
