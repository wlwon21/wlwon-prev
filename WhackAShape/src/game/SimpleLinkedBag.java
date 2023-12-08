// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- Ji Won Kim (jiwon21)

package game;

import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * The class for the SimpleLinkedBag that will be using the
 * linked bag to store items
 * 
 * @author Ji Won Kim
 * @version 2022.10.02
 * @param <T>
 *            the type
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {

    private Node<T> firstNode;
    private int numberOfEntries;

    /**
     * The constructor for the SimpleLinkedBag
     */
    public SimpleLinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     * Adds an item to the bag
     * 
     * @param anEntry
     *            The item that will be added to the bag
     * @return true if the item is empty
     * 
     */
    @Override
    public boolean add(T anEntry) {
        Node<T> node = new Node<T>(anEntry);
        if (anEntry == null) {
            return false;
        }
        node.setNext(firstNode);
        firstNode = node;
        numberOfEntries++;
        return true;
    }


    /**
     * Returns the current size of the bag
     * 
     * @return returns the size of the bag
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * Returns a boolean value showing whether or not
     * the bag is empty
     * 
     * @return true if the bag is empty
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * Picks a random item from the bag and returns it
     * 
     * @return a random item from the bag
     */
    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);
        Node<T> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getData();
    }


    /**
     * Removes the item from the bag
     * 
     * @param anEntry
     *            The item that will be removed
     * @return true if the item is removed from the bag
     */
    @Override
    public boolean remove(T anEntry) {
        Node<T> node = getReferenceTo(anEntry);
        if (getReferenceTo(anEntry) == null) {
            return false;
        }
        node.setData(firstNode.getData());
        firstNode = firstNode.getNext();
        numberOfEntries--;
        return true;
    }


    /**
     * Finds the node that references the specified item
     * 
     * @param anEntry
     *            The item that will be searched
     * @return the node that references the item
     */
    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && currentNode != null) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            }
            else {
                currentNode = currentNode.getNext();
            }
        }
        return currentNode;
    }
}
