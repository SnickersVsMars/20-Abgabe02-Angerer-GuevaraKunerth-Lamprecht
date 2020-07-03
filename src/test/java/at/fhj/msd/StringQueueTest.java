package at.fhj.msd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  Testing class StringQueue Class
 *
 * @author martin g.k.
 * @version %I%, %G%
 * @since 1.1
 */

@DisplayName("Testing StringQueue Implementation")
class StringQueueTest {
    private StringQueue q;

    /**
     * inits a StringQueue object to be able to test methods
     */
  @BeforeEach
    void setup() {
      q = new StringQueue(6);
  }

    /**
     * Tests constructor
     */
    @Test
    @DisplayName("testing StringQueue constructor")
    public void testConstructor () {
        assertNull(q.poll());
        assertEquals(6,q.getMaxSize());
    }

    /**
     * Tests offer method. I offer String objects to q until I reach maxSize. Before maxSize everything
     * should assert to true, everything above should assert to false.
     */
    @Test
    @DisplayName("Testing 'offer' method")
    public void testOffer() {
        assertTrue(q.offer("1"));
        assertTrue(q.offer("2"));
        assertTrue(q.offer("3"));
        assertTrue(q.offer("4"));
        assertTrue(q.offer("5"));
        assertTrue(q.offer("6"));
        assertFalse(q.offer("7"));
    }

    /**
     * Tests poll method. First I offer a String object to q. I then assert if my poll method returns the string.
     * Afterwards I call poll() again and test if it returns null.
     */
    @Test
    @DisplayName("Testing 'poll' method")
    public void testPoll() {
        q.offer("1");
        assertEquals("1",q.poll());
        assertNull(q.poll());
    }

    /**
     * Tests remove method. First I offer a String object to q. I then assert if my remove method returns the string.
     * Afterwards I call remove() again and test if it throws exception.
     */
    @Test
    @DisplayName("Testing 'remove' method")
    public void testRemove() {
        q.offer("1");
        assertEquals("1", q.remove());
        assertThrows(NoSuchElementException.class, ()-> {q.remove();});
    }

    /**
     * Tests peek method. First I offer a String object to q. I then assert if my peek method returns the string.
     */
    @Test
    @DisplayName("Testing 'peek' method")
    public void testPeek() {
        q.offer("1");
        assertEquals("1", q.peek());
    }

    /**
     * Tests element method. First I offer a String object to q. I then assert if my element method returns the string.
     * Than I remove the String object and assert if a NoSuchElementException is thrown.
     */
    @Test
    @DisplayName("Testing 'element' method")
    public void testElement() {
        q.offer("1");
        assertEquals("1", q.element());
        q.remove();
        assertThrows(NoSuchElementException.class, ()-> {q.element();});
    }

}