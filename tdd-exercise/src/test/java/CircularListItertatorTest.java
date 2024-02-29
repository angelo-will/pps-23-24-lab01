import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tddstep2.CircularListIterable;
import tddstep2.CircularListIterableImpl;

public class CircularListItertatorTest {

    private CircularListIterable circularList;

    @Test
    public void initializeList(){
        this.circularList = new CircularListIterableImpl();
    }
}
