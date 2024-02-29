import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tddstep2.CircularListIterable;
import tddstep2.CircularListIterableImpl;

public class CircularListItertatorTest {

    private CircularListIterable circularList;

    @BeforeEach
    public void initializeList() {
        this.circularList = new CircularListIterableImpl();
    }

    @Test
    public void testAdd() {
        this.circularList.add(0);
    }

    @Test
    public void tesSizeWithEmptyList() {
        assertEquals(0, this.circularList.size());
    }

    @Test
    public void testSizeWithElements() {
        int elementsQuantity = 10;
        IntStream.range(0, elementsQuantity).forEach(integer -> this.circularList.add(integer));
        assertEquals(elementsQuantity, this.circularList.size());
    }

    @Test
    public void testIsEmptyWithEmptyList() {
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    public void testIsEmptyWithListNotEmpty() {
        this.circularList.add(0);
        assertFalse(this.circularList.isEmpty());
    }

    @Test
    public void testForwardIteratorCircularity() {
        int elementsQuantity = 10;
        IntStream.range(0, elementsQuantity).forEach(integer -> this.circularList.add(integer));
        Iterator<Integer> iterator = this.circularList.forwardIterator();
        IntStream.range(0, elementsQuantity).forEach(integer -> assertEquals(integer, iterator.next()));
        IntStream.range(0, elementsQuantity).forEach(integer -> assertEquals(integer, iterator.next()));
    }
}
