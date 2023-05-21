package module9.mylist.mylinkedlist;

import module9.mylist.MyList;
import org.w3c.dom.Node;

import java.util.Iterator;

public class MyLinkedList <E> implements MyList<E> {
    private Node<E> element;


    @Override
    public void add(E e) {

        Node<E> node = new Node<>();
        node.setItem(e);
        if (element == null){

        element = node;}
        else {
            Node<E> last = element;
            while (last.getNext() != null){
                last.setPrev(last);
                last = last.getNext();
            }
            last.setNext(node);
        }
    }

    @Override
    public void remove(int index) {
        if (element == null){
            throw new IndexOutOfBoundsException();
        }
        if(index > size()){
            throw new IndexOutOfBoundsException();
        }
        Node<E> delete = element;
        Node<E> first = delete.getPrev();
        Node<E> last = delete.getNext();
        for (int i = 0; i < index; i++){
            first = delete.getPrev();
            delete = delete.getNext();
            last =  delete.getNext();
        }
        first.setNext(last);
        last.setPrev(first);
    }

    @Override
    public E get(int index) {
        if (element == null){
            throw new IndexOutOfBoundsException();
        }
        if(index > size()){
            throw new IndexOutOfBoundsException();
        }

        Node<E> search = element;
        for (int i = 0; i < index; i++){
            search = search.getNext();
        }
        return search.getItem();

    }

    @Override
    public int size() {
        if (element == null)
        {
        return 0;
        }
            int index = 1;
            Node<E> last = element;
            while (last.getNext() != null) {
                last = last.getNext();
                index++;
        }
        return index;

    }

    @Override
    public void clear() {
        element = null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size(); i++){
            if (i == 0){
                result.append(String.valueOf(get(i)));
            }else {
            result.append(String.valueOf(", " + get(i)));}
        }
        return "["+ result.toString() + "]";
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < size();
            }

            @Override
            public Object next() {
                return get(counter++);
            }
        };
    }
    private static class Node<E> {
       private E item;
        private Node<E> next;

       private Node<E> prev;

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}
