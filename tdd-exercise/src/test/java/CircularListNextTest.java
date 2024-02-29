import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tddstep3.CircularListNext;
import tddstep3.CircularListNextImpl;

public class CircularListNextTest extends CircularListTest {
    private CircularListNext circularList;

    @BeforeEach
    @Override
    public void initializeList() {
        this.circularList = new CircularListNextImpl();
    }

    @Test
    public void testNextWithEmptyList() {
        this.circularList.filteredNext(element -> element == 4);
    }
}
