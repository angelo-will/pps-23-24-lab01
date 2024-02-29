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
        int actualIndex = this.index;
        this.index = this.index + 1 >= this.size() ? 0 : this.index + 1;
        return this.getElement(actualIndex);
    }

    @Override
    public Optional<Integer> previous() {
        this.index = this.index - 1 < 0 ? this.size() - 1 : this.index - 1;
        return this.getElement(this.index);
    }
    
    @Override
    public void reset() {
        this.index = 0;
    }
    
    private Optional<Integer> getElement(int index){
        return this.isEmpty() ? Optional.empty() : Optional.of(this.list.get(index));
    }
}
