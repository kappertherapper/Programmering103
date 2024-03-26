package afleveringstuderende;

public class DictionaryDoubleHashing<K, V> implements Dictionary<K, V> {
    private final Entry DELETED = new Entry(null, null);
    private Entry<K, V>[] table;
    private int size;
    private double loadFactor = 0.50;

    public DictionaryDoubleHashing(int length) {
        table = new Entry[length];
        size = 0;
    }

    //-----------------------------------------------------------------------------------------------------------------

    @Override
    public V get(K key) {
        int index = hash(key);

        if (table[index] != null && table[index].key.equals(key)) {
            return table[index].value;
        } else if (table[index] != null || table[index] != DELETED) {
            boolean found = false;
            int x = 1;
            int newIndex = index + hashHash(key);
            while (table[newIndex] != null && newIndex != index) {
                newIndex = (hashHash(key) * table.length);
                if (table[newIndex].key.equals(key)) {
                    return table[newIndex].value;
                }
            }
            x++;
            newIndex = (index + newIndex * x) % table.length;
        }
        return null;
    }

    //-----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //-----------------------------------------------------------------------------------------------------------------

    @Override
    public V put(K key, V value) {
        int index = hash(key);

        if (table[index] == null || table[index].equals(DELETED)) {
            table[index] = new Entry<>(key, value);
            size++;
            return null;
        }

        if (table[index].key.equals(key)) {
            V oldValue = table[index].value;
            table[index].value = value;
            size++;
            return oldValue;
        }

        int newIndex = (index + hashHash(key)) % table.length;
        int x = 1;

        while (newIndex != index) {
            if (table[newIndex] == null || table[newIndex] == DELETED) {
                table[newIndex] = new Entry<>(key, value);
                size++;
                return null;
            }
            x++;
            newIndex = (index + newIndex * x) % table.length;
        }
        return null;
    }

    //-----------------------------------------------------------------------------------------------------------------

    @Override
    public V remove(K key) {
        int index = hash(key);

        if (table[index] == null || table[index].equals(DELETED) || index == -1) {
            return null;
        }

        if (table[index].key.equals(key)) {
            V oldValue = table[index].value;
            table[index] = DELETED;
            size--;
            return oldValue;
        }

        int newIndex = (index + hashHash(key)) % table.length;
        int x = 1;

        while (newIndex != index) {
            if (table[newIndex].key.equals(key)) {
                V oldValue = table[newIndex].value;
                table[newIndex] = DELETED;
                size--;
                return oldValue;
            }
            x++;
            newIndex = (index + newIndex * x) % table.length;
        }
        return null;
    }

    //-----------------------------------------------------------------------------------------------------------------

    @Override
    public int size() {
        return size;
    }

    //-----------------------------------------------------------------------------------------------------------------

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    private int hashHash(K key) {
        int hashKey = key.hashCode();
        return 7 - (hashKey % 7);
    }

    //-----------------------------------------------------------------------------------------------------------------

    public void writeOut() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + "\t" + table[i]);
        }
    }

    //-----------------------------------------------------------------------------------------------------------------

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public String toString() {
            return "(" + key + " , " + value + ")";
        }
    }
}
