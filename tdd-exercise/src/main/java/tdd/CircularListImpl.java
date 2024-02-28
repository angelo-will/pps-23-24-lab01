package tdd;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public class CircularListImpl implements CircularList {

    private List<Integer> list;
    private int index;

    public CircularListImpl() {
        this.list = new ArrayList<Integer>();
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
    public Optional<Integer> next() {
        Optional<Integer> value = this.isEmpty() ? Optional.empty() : Optional.of(this.list.get(this.index));
        this.index = this.index + 1 >= this.size() ? 0 : this.index + 1;
        return value;
    }

    @Override
    public Optional<Integer> previous() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'previous'");
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }
}
