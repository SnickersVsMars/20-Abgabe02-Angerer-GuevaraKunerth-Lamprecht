package at.fhj.msd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
     * Integer that defines the maximum amount of elements in the queue
     */
    private int maxSize;
    /**
     * Public constructor of the GenericQueue
     *
     * @param maxSize integer that sets the maximum size of the queue
     */
    public GenericQueue(int maxSize) {
        setMaxSize(maxSize);
    }

    /**
     * getter for maxSize so one can easily get the current size of the queue
     *
     * @return maxSize of the queue
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * setter for maxSize to create the ability to adapt the size of queue later on
     *
     * @param maxSize given parameter will be the new maxSize
     */
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
}

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
     * @return top element of queue if exists else null
     */
    @Override
    public T poll() {
        T element = peek();
        if (element != null){
            elements.remove(0);
        }else {
            return null;
        }
        return element;
    }

    /**
     * It also returns and deletes the head element like poll(), but with a small difference.
     * This method throws NoSuchElementException if the queue is empty.
     *
     * @return top element of queue if exists else throws new NoSuchElementException
     */
    @Override
    public T remove() {
        T element = poll();
        if (element == null){
            throw new NoSuchElementException();
        }
        return element;
    }

    /**
     * Returns the head element but it does not delete it. That is, we can get it again.
     * Returns null when the queue is empty.
     *
     * @return top element of queue if exists else null
     */
    @Override
    public T peek() {
        T element;
        if(elements.size() > 0){
            element = elements.get(0);
        }else {
            return null;
        }
        return element;
    }

    /**
     * It works similar to peek() but with a small difference (returns but does not delete the element).
     * It throws NoSuchElementException when the queue is empty.
     *
     * @return top element of queue if exists else throws new NoSuchElementException
     */
    @Override
    public T element() {
        T element = peek();
        if(element == null){
            throw new NoSuchElementException("There is no element in the queue!");
        }
        return element;
    }
}
