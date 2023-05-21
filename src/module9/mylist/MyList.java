package module9.mylist;

public interface MyList<E> extends Iterable<E>{
    void add(E e);
    void remove(int index);
    E get(int index);
    int size();
    void clear();
}
