package at.fhj.msd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing GenericQueue with the class String")
public class StringGenericQueueTest {
    private static GenericQueue<String> q;

    @BeforeAll
    static void  beforeAll(){
        q = new GenericQueue<>(5);
    }
    @Test
    @DisplayName("Testing constructor")
    public void testConstructor(){
        assertNull(q.poll());
        assertEquals(5, q.getMaxSize());
    }
    @Test
    @DisplayName("Testing offer method")
    public void testOffer(){
        assertTrue(q.offer("a"));
        assertTrue(q.offer("b"));
        assertTrue(q.offer("c"));
        assertTrue(q.offer("d"));
        assertTrue(q.offer("e"));
        assertFalse(q.offer("f"));
    }
}
