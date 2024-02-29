package tddstep2;

import java.util.Iterator;

public interface CircularListIterable {

    public void add(int element);

    public int size();

    public boolean isEmpty();

    public Iterator<Integer> forwardIterator();

    public Iterator<Integer> backwardIterator();

}
