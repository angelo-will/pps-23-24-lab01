import org.junit.jupiter.api.BeforeEach;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    public void initializeList(){
        this.circularList = new CircularListImpl();
    }

}
