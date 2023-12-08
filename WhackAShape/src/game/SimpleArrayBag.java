// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
// nor will I accept the actions of those who do.
// -- Ji Won Kim (jiwon21)

package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * The class for the SimpleArrayBag that will use an array to 
 * store items
 * @author Ji Won Kim
 * @version 2022.10.02
 * @param <T> the type
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    private final static int MAX = 18;
    private T[] bag;
    private int numberOfEntries;
    
    /**
     * The constructor of the SimpleArrayBag<T> class
     */
    @SuppressWarnings("unchecked")
    public SimpleArrayBag() {
        T[] tempbag = (T[]) new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
    }
    
    /**
     * Adds an item to the bag
     * 
     * @param anEntry the item that will be added to the bag
     * @return true if the item is added
     */
    @Override
    public boolean add(T anEntry) {   
        if (numberOfEntries < MAX && anEntry != null)
        {
            bag[numberOfEntries] = anEntry;
            numberOfEntries++;
            return true;
        }
        return false;
    }

    /**
     * Returns the current size of the bag
     * @return the number of entries
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * Return whether the bag is empty or not
     * @return true if the bag is empty
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Picks and return a random item in the bag
     * @return the item in the bag
     */
    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }
        TestableRandom generator = new TestableRandom(); 
        int index = generator.nextInt(numberOfEntries);
        return bag[index];
    }

    /**
     * Removes the item from the bag if the bag contains 
     * anEntry 
     * @param anEntry the item that will be removed
     * @return whether or not the item has been remove.
     */
    @Override
    public boolean remove(T anEntry) {
        if (getIndexOf(anEntry) == -1) {
            return false;
        }
        bag[getIndexOf(anEntry)] = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return true;
    }
    
    /**
     * Returns the index of the entry
     * @param anEntry The item that will be checked
     * @return the index of the anEntry
     */
    private int getIndexOf(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }
        return -1;
    }

}
