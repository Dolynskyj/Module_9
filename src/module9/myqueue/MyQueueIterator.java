package module9.myqueue;

import java.util.Iterator;

public class MyQueueIterator<E> implements Iterator<E> {
    private  int index =0;
    E[] values;

    public MyQueueIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }
}
