package module9.mylist.myarraylist;

import module9.mylist.MyList;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {
    private E[] values;
    public MyArrayList(){
        values =(E[]) new Object[0];
    }
//    додаємо елемент в кінець
    @Override
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



    //    видаляєvj елемент із вказаним індексом
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

//повертаємо елемент за індексом
    @Override
    public E get(int index) {
        return values[index];
    }

//повертаємо розмір колекції
    @Override
    public int size() {
        return values.length;
    }

//    очищаємо колекцію
    @Override
    public void clear() {
        values = (E[]) new Object[0];
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }

    @Override
    public String toString() {
        return  Arrays.toString(values);
    }
}
