package tddstep2;

import java.util.Iterator;
import java.util.Optional;

public interface CircularListIterable {

    public void add(int element);

    public int size();

    public boolean isEmpty();

    public Iterator<Optional<Integer>> forwardIterator();

    public Iterator<Optional<Integer>> backwardIterator();

}
