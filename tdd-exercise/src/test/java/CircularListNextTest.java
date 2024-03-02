import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tddstep3.CircularListNext;
import tddstep3.CircularListNextImpl;

public class CircularListNextTest extends CircularListTest {
    private CircularListNext circularListNext;

    @BeforeEach
    @Override
    public void initializeList() {
        this.circularList = new CircularListNextImpl();
        this.circularListNext = new CircularListNextImpl();
    }

    @Test
    public void testNextWithEmptyList() {
        assertEquals(Optional.empty(), this.circularListNext.filteredNext(element -> element == 0));
    }

    @Test
    public void testNextWithoutElement() {
        int elementToTest = 4;
        this.circularListNext.add(0);
        assertEquals(Optional.empty(), this.circularListNext.filteredNext(element -> element == elementToTest));
    }

    @Test
    public void textNextWithMoreElements() {
        int elementsQuantity = 10;
        int elementToTest1 = 11;
        int elementToTest2 = 12;
        IntStream.range(0, elementsQuantity).forEach(element -> this.circularListNext.add(element)); 
        this.circularListNext.add(elementToTest1);
        this.circularListNext.add(elementToTest2);
        assertEquals(Optional.of(elementToTest1), this.circularListNext.filteredNext(element -> element == elementToTest1));
        assertEquals(Optional.of(elementToTest1), this.circularListNext.filteredNext(element -> element == elementToTest1));
        assertEquals(Optional.of(elementToTest2), this.circularListNext.filteredNext(element -> element == elementToTest2));
    }
}
