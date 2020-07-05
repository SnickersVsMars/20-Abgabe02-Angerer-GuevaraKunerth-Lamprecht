package at.fhj.msd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

/**
 * This Testclass is used to test the GenericQueue with the class String
 *
 * @author Samuel Angerer
 * @version %I%, %G%
 * @since 1.1
 */
@DisplayName("Testing GenericQueue with the class String")
public class StringGenericQueueTest {
    private GenericQueue<String> q;

    /**
     * Sets up a new fresh queue before every test so the test that alter the queue don't impact
     * other tests
     */
    @BeforeEach
    void beforeEach(){
        q = new GenericQueue<>(5);
    }

    /**
     * This test tests the constructor, it checks if the new queue is empty and if the maxSize
     * is set correctly via the getter
     */
    @Test
    @DisplayName("Testing constructor")
    public void testConstructor(){
        assertNull(q.poll());
        assertEquals(5, q.getMaxSize());
    }

    /**
     * This test tests the offer method, it offers Strings for as long as the maxSize is and the
     * next offered object should get rejected
     */
    @Test
    @DisplayName("Testing offer method")
    public void testOffer(){
        for (int i = 0; i < 5; i++) {
            assertTrue(q.offer("t"));
        }
        assertFalse(q.offer("f"));
    }

    /**
     * This test tests the poll method, first we add the string "a", then we call poll so we should
     * get "a", since the queue is empty now the next poll should return null
     */
    @Test
    @DisplayName("Testing poll method")
    public void testPoll(){
        q.offer("a");
        assertEquals("a", q.poll());
        assertNull(q.poll());
    }

    /**
     * This test tests the remove method, first we add an element, then we remove it to check if it
     * works properly, since the queue is empty now the next remove call should throw an exception
     */
    @Test
    @DisplayName("Testing remove method")
    public void testRemove(){
        q.offer("a");
        assertEquals("a", q.remove());
        assertThrows(NoSuchElementException.class, ()->{q.remove();});
    }

    /**
     * This test tests the element method, first we test if the call of element throws the exception, which it
     * should do as the queue is empty, after that we offer an element and call element again to check if
     * the right value is returned
     */
    @Test
    @DisplayName("Testing element method")
    public void testElement(){
        assertThrows(NoSuchElementException.class, ()->{q.element();});
        q.offer("a");
        assertEquals("a", q.element());
    }
}
