package module9.mymap.myhashmap;

import module9.mymap.MyMap;
import org.w3c.dom.Node;

import java.util.*;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private MyNode<K, V>[] hashMap;
    private int size = 0;
    private float threshold;
    public MyHashMap(){
        hashMap = new MyNode[16];
        threshold = hashMap.length * 0.75f;
    }
    private int hash(K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashMap.length;
    }

//    додає пару ключ + значення
    @Override
    public boolean put(K key,V value) {
        if (size +1 >= threshold){
            threshold *= 2;
            arrayDoubling();
        }
        MyNode<K, V> newNode = new MyNode<>(key, value);
        int index = newNode.hash();

        if (hashMap[index] == null){
            return  simpeleAdd(index, newNode);
        }
        List<MyNode<K, V>> nodeList = hashMap[index].getNotes();
        for (MyNode<K, V> node : nodeList){
            if (keyExistButValueNew(node, newNode, value) || collisionProcessing(node, newNode, nodeList)){
                return true;
            }
        }
        return false;
    }
    private boolean simpeleAdd(int index, MyNode<K, V> newNode){
        hashMap[index] = new MyNode<>(null, null);
        hashMap[index].getNotes().add(newNode);
        size++;
        return true;
    }
    private boolean keyExistButValueNew(
            final MyNode<K,V> nodeFromList,
            final MyNode<K,V> nodeNode,
            final V value) {
        if (nodeNode.getKey().equals(nodeFromList.getKey()) &&
        !nodeNode.getValue().equals(nodeFromList.getValue())){
            nodeFromList.setValue(value);
            return true;
        }
        return false;
    }
    private boolean collisionProcessing(
            final MyNode<K,V> nodeFromList,
            final MyNode<K,V> newNode,
            final List<MyNode<K, V>> nodes){
        if (newNode.hashCode() == nodeFromList.hashCode() &&
        !Objects.equals(newNode.key, nodeFromList.key) &&
        !Objects.equals(newNode.value, nodeFromList.value)){
            nodes.add(newNode);
            size++;
            return true;
        }
        return false;
    }
    private void arrayDoubling() {
        MyNode<K, V>[] oldHashMap = hashMap;
        hashMap = new MyNode[oldHashMap.length * 2];
        size = 0;
        for(MyNode<K, V> node : oldHashMap) {
            if (node != null) {
                for (MyNode<K, V> n : node.getNotes()){
                    put(n.key, n.value);
                }
            }
        }
    }


//    видаляє пару за ключем
    @Override
    public boolean remove(K key) {
        int index = hash(key);
        if (hashMap[index] == null)
            return false;

        if(hashMap[index].getNotes().size() == 1) {
            hashMap[index].getNotes().remove(0);
            size--;
            return true;
        }
        List<MyNode<K, V>> nodeList = hashMap[index].getNotes();
        for (MyNode<K, V> node : nodeList){
            if (key.equals(node.getKey())){
                nodeList.remove(node);
                size--;
                return true;
            }
        }
        return false;
    }

//    очищає колекцію
    @Override
    public void clear() {
        hashMap = new MyNode[16];
        size = 0;
    }

//    повертає розмір колекції
    @Override
    public int size() {
        return size;
    }
//    повертає значення (Object value) за ключем
    @Override
    public V get(K key) {
        int index = hash(key);
        if (index < hashMap.length && hashMap[index] != null) {
            List<MyNode<K, V>> list = hashMap[index].getNotes();
            for (MyNode<K, V> node : list) {
                if (key.equals(node.getKey())){
                    return node.getValue();
                }
            }
        }
        return null;
    }


    private class MyNode<K, V>{
        private List<MyNode<K, V>> notes;
        private int hash;
        private K key;
        private V value;
        private MyNode(K key, V value){
            this.key = key;
            this.value = value;
            notes = new LinkedList<MyNode<K, V>>();
        }

        private int hash(){
            return hashCode() % hashMap.length;
        }

        public List<MyNode<K, V>> getNotes() {
            return notes;
        }

//        public void setNotes(List<MyNode<K, V>> notes) {
//            this.notes = notes;
//        }

        public K getKey() {
            return key;
        }

//        public void setKey(K key) {
//            this.key = key;
//        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj instanceof MyNode){
                MyNode<K, V> node = (MyNode) obj;
                return (Objects.equals(key, node.getKey()) &&
                        Objects.equals(value, node.getValue()) ||
                        Objects.equals(hash, node.hashCode()));
            }
            return false;
        }
    }
}
