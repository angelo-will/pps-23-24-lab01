package tddstep3;

import java.util.Optional;
import java.util.function.Predicate;

import tdd.CircularListImpl;

public class CircularListNextImpl extends CircularListImpl implements CircularListNext {

    private int nextIndex;

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {

        Optional<Integer> elementFound = Optional.empty();

        for (int i = 0; i < this.size() && elementFound.isEmpty(); i++) {
            var listElement = Optional.of(this.list.get(this.getCircularIndex(i + nextIndex)));
            if (predicate.test(listElement.get())) {
                elementFound = listElement;   
            }
        }

        return elementFound;

    }

    private int getCircularIndex(int index) {
        return index % this.size();
    }

}
