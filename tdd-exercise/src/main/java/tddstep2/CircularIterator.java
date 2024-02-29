package tddstep2;

import java.util.Iterator;

public abstract class CircularIterator<T> implements Iterator<T> {
    private int index;

    public void setIndex(final int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public abstract T next();

}
