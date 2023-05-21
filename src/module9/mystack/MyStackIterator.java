package module9.mystack;

import java.util.Iterator;

public class MyStackIterator <E> implements Iterator<E> {
    private  int index =0;
    E[] values;

    public MyStackIterator(E[] values) {
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
