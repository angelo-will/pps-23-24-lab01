package tddstep3;

import java.util.Optional;
import java.util.function.Predicate;

import tdd.CircularList;

public interface CircularListNext extends CircularList {

    public Optional<Integer> filteredNext(Predicate<Integer> predicate);

}
