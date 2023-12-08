// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
// nor will I accept the actions of those who do.
// -- Ji Won Kim (jiwon21)


package game;

import bag.SimpleBagInterface;
import student.TestableRandom;
import java.awt.*;
import cs2.Window;
import cs2.CircleShape;
import cs2.Shape;
import cs2.SquareShape;
import cs2.TextShape;
import cs2.Button;
import cs2.WindowSide;

/**
 * @author Ji Won Kim
 * @version 2022.10.02
 *
 */
public class WhackAShape {
    
    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;
    
    /**
     * The default constructor of WhackAShape
     */
    public WhackAShape() {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        randomGenerator = new TestableRandom();
        int size = randomGenerator.nextInt(6) + 8;
        String[] shape = {"red circle", "blue circle", "red square",
            "blue square"};
        
        Button quitButton = new Button("quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.EAST);
        
        for (int i = 0; i < size; i++) {
            bag.add(buildShape(shape[randomGenerator.nextInt(4)]));
        }
        window.addShape(bag.pick());   
    }
    
    /**
     * Another constructor of WhackAShape that takes in a array of string
     * as parameter. Adds the shape to the bag if the item inside the
     * array is one either red or blue circle or square
     * @param inputs the array of strings that has the shapes 
     * that will be added to the bag
     */
    public WhackAShape(String[] inputs) {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        randomGenerator = new TestableRandom();
        
        Button quitButton = new Button("quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.EAST);
        
        for (int i = 0; i < inputs.length; i++) {
            Exception thrown = null;
            try {
                bag.add(buildShape(inputs[i]));
            }
            catch (Exception e) {
                thrown = e;
                thrown.printStackTrace();
            }
        }
        window.addShape(bag.pick());
    }
    
    /**
     * Returns the bag of shapes
     * @return the bag
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;
    }
    
    /**
     * Returns the window of the project
     * @return the window
     */
    public Window getWindow() {
        return window;
    }
    
    /**
     * Closes the window when the button is clicked
     * @param button the quit button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }
    
    /**
     * Removes the shape and adds a new shape randomly from the
     * bag when the shape is clicked.
     * @param shape The shape that is clicked
     */
    public void clickedShape(Shape shape) {
        window.removeShape(shape);
        bag.remove(shape);
        Shape nextShape = bag.pick();
        if (nextShape == null) {
            TextShape text = new TextShape(0, 0, "You Win!");
            int x = window.getGraphPanelWidth()/2 - text.getWidth()/2;
            int y = window.getGraphPanelHeight()/2 - text.getHeight()/2;
            window.addShape(text);
            text.moveTo(x, y);
        }
        window.addShape(nextShape);
    }
    
    /**
     * Builds the shape that will be added. 
     * Only allows red or blue circles or squares
     * @param shape The string that represents the shape
     * @return the shape
     */
    private Shape buildShape(String shape) {
        int size = randomGenerator.nextInt(101) + 100;
        int x = randomGenerator.nextInt(window.getGraphPanelWidth()
            - size);
        int y = randomGenerator.nextInt(window.getGraphPanelHeight()
            - size);
        Shape currentShape = null;
        
        if (!shape.contains("red") && !shape.contains("blue")) {
            throw new IllegalArgumentException();
        }
        if (!shape.contains("circle") && !shape.contains("square")) {
            throw new IllegalArgumentException();
        }
        if (shape.contains("circle")) {
            if (shape.contains("red")) {
                currentShape = new CircleShape(x, y, size, Color.RED);
            }
            else if (shape.contains("blue")) {
                currentShape = new CircleShape(x, y, size, Color.BLUE);
            }
        }
        if (shape.contains("square")) {
            if (shape.contains("red")) {
                currentShape = new SquareShape(x, y, size, Color.RED);
            }
            else if (shape.contains("blue")) {
                currentShape = new SquareShape(x, y, size, Color.BLUE);
            }
        }
        currentShape.onClick(this, "clickedShape");       
        return currentShape;
    }
}