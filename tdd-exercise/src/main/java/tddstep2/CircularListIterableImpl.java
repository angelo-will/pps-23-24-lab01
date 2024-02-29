package tddstep2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CircularListIterableImpl implements CircularListIterable {

    private List<Integer> list;

    public CircularListIterableImpl(){
        this.list = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'forwardIterator'");
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'backwardIterator'");
    }

}
