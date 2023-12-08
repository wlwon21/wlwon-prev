// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the 
// actions of those who do.
// -- Ji Won Kim (jiwon21)

package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;

/**
 * The LinkedStack<T> class that implements the StackInterface<T>
 * 
 * @author Ji Won Kim
 * @version 2022.10.18
 *
 * @param <T> The type that will be stored in stack
 */
public class LinkedStack<T> implements StackInterface<T> {

    private int size;
    private Node topNode;
    
    /**
     * The constructor for this class
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }
    
    /**
     * Returns the size of the stack
     * 
     * @return size of the stack
     */
    public int size() {
        return size;
    }
    
    /**
     * Clears the stack
     */
    @Override
    public void clear() {
        topNode = null;
        size = 0;

    }

    /**
     * Checks if the stack is empty
     * 
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Shows the data that is on the top of the stack
     * 
     * @throws EmptyStackException the stack is empty
     * @return the data on the top of the stack
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }

    /**
     * Pops the data on the top
     * 
     * @throws EmptyStackException the stack is empty
     * @return the data that is popped
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T top = peek();
        topNode = topNode.getNextNode();
        size--;
        return top;
    }


    /**
     * Pushes a new entry on the top of the stack
     */
    @Override
    public void push(T anEntry) {
        topNode = new Node(anEntry, topNode);
        size++;
    }
    
    /**
     * Returns the data in the stack
     * 
     * @return all the data in the stack
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder stack =  new StringBuilder();
        stack.append("[");
        Node n = topNode;
        while (n != null) {
            if (stack.length() > 1) {
                stack.append(", ");
            }
            stack.append(n.getData());
            n = n.getNextNode();
        }
        stack.append("]");
        return stack.toString();
    }
    
    /**
     * Private Node class
     * 
     * @author Ji Won Kim
     *
     */
    private class Node {
        private T data;
        private Node next;
        
        /**
         * The constructor that takes in two parameter
         * 
         * @param entry 
         * @param node
         */
        public Node(T entry, Node node) {
            this(entry);
            this.setNextNode(node);
        }
        
        /**
         * Constructor that only takes in one data
         * 
         * @param data 
         */
        public Node(T data) 
        { 
            this.data = data; 
        }
        
        /**
         * Sets the next Node
         * @param node the node that will be set next
         */
        public void setNextNode(Node node) {
            this.next = node;
        }
        
        /**
         * Returns the next node
         * @return next node
         */
        public Node getNextNode() {
            return next;
        }
        
        /**
         * Returns the current data
         * @return the data that is stored in the node
         */
        public T getData() {
            return data;
        }
    }
}
