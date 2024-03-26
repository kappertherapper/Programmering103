package dictionaryelev;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.hash;

public class DictionaryHashMap<K, V> implements Dictionary<K, V> {

    private Map<K, V>[] tabel;
    private static int N = 13;

    /**
     * HashingMap constructor comment.
     */

    public DictionaryHashMap() {
        tabel = new HashMap[N];
        for (int i = 0; i < N; i++) {
            tabel[i] = new HashMap<K, V>();
        }
    }

    @Override
    public V get(K key) {
        int hash = Math.abs(key.hashCode() % N);
        return tabel[hash].get(key);
}

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public V put(K key, V value) {
        int hash = Math.abs(key.hashCode() % N);
        return tabel[hash].put(key, value);
    }

    @Override
    public V remove(K key) {
        int hash = Math.abs(key.hashCode() % N);
        return tabel[hash].remove(key);
    }

    @Override
    public int size() {
        return tabel.length;
    }

}
