package tddstep2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CircularListIterableImpl implements CircularListIterable {

    private List<Integer> list;

    public CircularListIterableImpl() {
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
        return new Iterator<Integer>() {
            private int index;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                int actualValue = list.get(index);
                this.index = this.index + 1 >= list.size() ? 0 : this.index + 1;
                return actualValue;
            }

        };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'backwardIterator'");
    }

}
