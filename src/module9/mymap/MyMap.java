package module9.mymap;

public interface MyMap<K, V> {
    boolean put(K key, V value);
    boolean remove(K key);
    void clear();
    int size();
    V get(K key);
}
