package tddstep2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
    public Iterator<Optional<Integer>> forwardIterator() {
        return new CircularIterator<Optional<Integer>>() {
            @Override
            public Optional<Integer> next() {
                Optional<Integer> actualValue = list.isEmpty() ? Optional.empty()
                        : Optional.of(list.get(this.getIndex()));
                this.indexPolicy();
                return actualValue;
            }

            private void indexPolicy() {
                this.setIndex(this.getIndex() + 1 >= list.size() ? 0 : this.getIndex() + 1);
            }
        };
    }

    @Override
    public Iterator<Optional<Integer>> backwardIterator() {
        return new Iterator<Optional<Integer>>() {
            private int index = list.size() - 1;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Optional<Integer> next() {
                Optional<Integer> actualValue = list.isEmpty() ? Optional.empty() : Optional.of(list.get(index));
                this.indexPolicy();
                return actualValue;
            }

            private void indexPolicy() {
                this.index = this.index <= 0 ? list.size() - 1 : this.index - 1;
            }

        };
    }

}
