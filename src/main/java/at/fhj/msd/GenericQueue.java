package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;

/**
 * Class represents another version of our StringQueue. The main difference
 * is the usage of Generics. The following queue is designed to work with more
 * datatypes than just Strings
 *
 * @author Samuel Angerer
 * @version %I%, %G%
 * @since 1.1
 */
public class GenericQueue<T> implements IQueue<T>{

    /**
     * List which contains the elements of the queue based on an
     * Arraylist
     */
    private List<T> elements = new ArrayList<>();
    /**
     * Integer that defines the maximum amount of elements in teh queue
     */
    private int maxSize = 5;
    /**
     * Adds the element obj to the queue.
     * If the addition is successful, the method returns true else false.
     *
     * @param obj object to be added to the queue
     * @return true if object can be added, else false
     */
    @Override
    public boolean offer(T obj) {
        if (elements.size() < maxSize){
            elements.add(obj);
        } else {
            return false;
        }
        return true;

    }

    /**
     * Returns the head (first) element and also deletes it. That is, we cannot get it again.
     * If no element exists (when queue is empty), the method returns null.
     *
     * @return
     */
    @Override
    public T poll() {
        return null;
    }

    /**
     * It also returns and deletes the head element like poll(), but with a small difference.
     * This method throws NoSuchElementException if the queue is empty.
     *
     * @return
     */
    @Override
    public T remove() {
        return null;
    }

    /**
     * Returns the head element but it does not delete it. That is, we can get it again.
     * Returns null when the queue is empty.
     *
     * @return
     */
    @Override
    public T peek() {
        return null;
    }

    /**
     * It works similar to peek() but with a small difference (returns but does not delete the element).
     * It throws NoSuchElementException when the queue is empty.
     *
     * @return
     */
    @Override
    public T element() {
        return null;
    }
}
