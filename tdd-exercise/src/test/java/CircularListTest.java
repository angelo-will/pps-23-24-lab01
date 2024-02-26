import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    public void initializeList() {
        this.circularList = new CircularListImpl();
    }

    @Test
    public void testInitialSize() {
        assertEquals(0, this.circularList.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(this.circularList.isEmpty());
    }
    
    @Test
    public void testSizeAfterAdd(){
        this.circularList.add(0);
        assertEquals(1,this.circularList.size());
    }
}
