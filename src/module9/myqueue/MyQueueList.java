package module9.myqueue;

public interface MyQueueList<E> extends Iterable<E> {
    void add(E e);
    E peek();
    E poll();
    int size();
    void clear();
}
