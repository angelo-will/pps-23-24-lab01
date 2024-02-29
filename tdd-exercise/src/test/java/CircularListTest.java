import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;
    private List<Integer> listForComparison;

    @BeforeEach
    public void initializeList() {
        this.circularList = new CircularListImpl();
        this.listForComparison = new ArrayList<>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    public void testIsEmptyAfterAdd() {
        this.circularList.add(0);
        assertFalse(this.circularList.isEmpty());
    }

    @Test
    public void testInitialSize() {
        assertEquals(0, this.circularList.size());
    }

    @Test
    public void testSizeAfterAdd() {
        this.circularList.add(0);
        assertEquals(1, this.circularList.size());
    }

    @Test
    public void testNextWithEmptyList() {
        assertEquals(Optional.empty(), this.circularList.next());
    }

    @Test
    public void testNextAfterAdd() {
        int elementToAdd = 0;
        this.circularList.add(elementToAdd);
        assertEquals(Optional.of(elementToAdd), this.circularList.next());
    }

    @Test
    public void testNextUsingCircularity() {
        int rangeUpperLimitList = 10;
        this.listForComparison = new ArrayList<>();
        IntStream.range(0, rangeUpperLimitList).forEach(i -> {
            this.circularList.add(i);
            this.listForComparison.add(i);
        });
        this.listForComparison.forEach(i -> assertEquals(i, this.circularList.next().get()));
        this.listForComparison.forEach(i -> assertEquals(i, this.circularList.next().get()));
    }

    @Test
    public void testPreviousWithEmptyList() {
        assertEquals(Optional.empty(), this.circularList.previous());
    }

    @Test
    public void testPreviousAfterAdd() {
        this.circularList.add(0);
        assertEquals(Optional.of(0), this.circularList.previous());
    }

    @Test
    public void testPreviousUsingCircularityWithOneElement() {
        this.circularList.add(0);
        IntStream.range(0, 10).forEach(i -> assertEquals(Optional.of(0), this.circularList.previous()));
    }

    @Test
    public void testPreviousUsingCircularityWithMoreElements() {
        int rangeUpperLimitList = 3;
        listForComparison = new ArrayList<>();
        IntStream.range(0, rangeUpperLimitList).forEach(i -> {
            this.circularList.add(i);
            this.listForComparison.add(rangeUpperLimitList - 1 - i);
        });
        this.listForComparison.forEach(element -> assertEquals(element, this.circularList.previous().get()));
        this.listForComparison.forEach(element -> assertEquals(element, this.circularList.previous().get()));
    }
}
