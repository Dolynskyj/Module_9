package module9.mystack;

public interface MyStackList<E> extends Iterable<E> {
    void push(E e);
    E peek();
    E pop();
    void remove(int index);
    int size();
    void clear();
}

