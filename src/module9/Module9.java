package module9;

import module9.mylist.MyList;
import module9.mylist.myarraylist.MyArrayList;
import module9.mylist.mylinkedlist.MyLinkedList;
import module9.mymap.MyMap;
import module9.mymap.myhashmap.MyHashMap;
import module9.myqueue.MyQueue;
import module9.myqueue.MyQueueList;
import module9.mystack.MyStack;
import module9.mystack.MyStackList;

import java.util.*;

public class Module9 {
    public static void main(String[] args) {
        MyList<String> myArrayList = new MyArrayList<>();
        MyList<String> muLinkedList = new MyLinkedList<>();
        MyQueueList<String> myQueue = new MyQueue<>();
        MyStackList<String> myStack = new MyStack<>();
        MyMap<String, String> myMap = new MyHashMap<>();

    }
}
