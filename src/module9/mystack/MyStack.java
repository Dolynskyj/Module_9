package module9.mystack;

import module9.myqueue.MyQueueIterator;

import java.util.Arrays;
import java.util.Iterator;

public class MyStack<E> implements MyStackList {
    private E[] values;
    public MyStack(){
        values =(E[]) new Object[0];
    }
//    додаємо елемент в кінець
    @Override
    public void push(Object o) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 1, temp.length);
            values[0] = (E) o;
        } catch (ClassCastException ex){
            ex.printStackTrace();
        }
    }

//    повертає перший елемент стеку
    @Override
    public Object peek() {
        if (values == null){
            return null;
        }
        return values[0];
    }

//    повертає перший елемент стеку та видаляє його з колекції
    @Override
    public Object pop() {
        if (values == null){
            return null;
        }
        E[] temp = values;
        values = (E[]) new Object[temp.length - 1];
        System.arraycopy(temp, 1, values, 0, temp.length - 1);
        return temp[0];
    }

//    видаляємо елемент за індексом
    @Override
    public void remove(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int numberOfItemsAfterIndex = temp.length - index - 1; //скільки елементів копіюємо.
            System.arraycopy(temp, index + 1, values, index, numberOfItemsAfterIndex);
        } catch (ClassCastException ex){
            ex.printStackTrace();
        }
    }
//    повертає розмір колекції
    @Override
    public int size() {
        return values.length;
    }

//    очищає колекцію
    @Override
    public void clear() {
        values = (E[]) new Object[0];
    }

    @Override
    public String toString() {
        return  Arrays.toString(values);
    }

    @Override
    public Iterator iterator() {
        return new MyStackIterator<>(values);
    }
}
