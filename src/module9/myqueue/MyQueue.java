package module9.myqueue;

import module9.mylist.myarraylist.ArrayIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<E> implements MyQueueList<E>{
    private E[] values;
    public MyQueue(){
        values =(E[]) new Object[0];
    }
    //    додаємо елемент в кінець
    public void add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
        } catch (ClassCastException ex){
            ex.printStackTrace();
        }
    }

    //    повертаємо перший елемент з черги
    public E peek() {
            if (values == null){
            return null;
        }
        return values[0];


    }

    //повертаємо перший елемент з черги і видаляє його з колекції
    public E poll() {
        if (values == null){
            return null;
        }
        E[] temp = values;
        values = (E[]) new Object[temp.length - 1];
        System.arraycopy(temp, 1, values, 0, temp.length - 1);
        return temp[0];
    }

    //повертаємо розмір колекції
    public int size() {
        return values.length;
    }

    //    очищаємо колекцію
    public void clear() {
        values = (E[]) new Object[0];
    }

    @Override
    public Iterator<E> iterator() {
        return new MyQueueIterator<>(values);
    }

    @Override
    public String toString() {
        return  Arrays.toString(values);
    }
}
