package Q1;

public class myHashMap<K, V> {

    private static final int defaultInitialCapacity = 16;
    private Entrance<K, V>[] entryTable;
    private int size;
    private int threshold;

    private Entrance<K, V>[] newTable(int n) {
        return (Entrance<K, V>[]) new Entrance<?, ?>[n];
    }

    public myHashMap() {
        this(defaultInitialCapacity, 10);
    }

    public myHashMap(int initialCapacity) {
        this(initialCapacity, 10);
    }

    public myHashMap(int initialCapacity, float loadFactor) {
        int capacity = 1;
        entryTable = newTable(capacity);
    }

    private static boolean eq(Object x, Object y) {
        return x == y || x.equals(y);
    }

    final int hash(Object key) {
        return Math.abs(key.hashCode()) % entryTable.length;
    }

    private Entrance<K, V>[] getTable() {
        return entryTable;
    }

    public V get(Object key) {

        int h = hash(key);
        Entrance<K, V>[] tab = getTable();
        Entrance<K, V> e = tab[h];
        while (e != null) {
            if (e.hash == h && eq(key, e.key)) {
                return e.value;
            }
            e = e.next;
        }
        return null;
    }

    private Entrance<K, V> getEntry(Object key) {
        int h = hash(key);
        Entrance<K, V>[] tab = getTable();
        Entrance<K, V> e = tab[h];
        while (e != null && !(e.hash == h && eq(key, e.key))) {
            e = e.next;
        }
        return e;
    }

    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    public V put(K key, V value) {

        int Hash = hash(key);
        Entrance<K, V>[] tab = getTable();
        Entrance<K, V> e = tab[Hash];
        tab[Hash] = new Entrance<>(Hash, key, value, e);

        return null;
    }

    static class Entrance<K, V> {

        final int hash;
        private K key;
        private V value;
        private Entrance<K, V> next;

        public Entrance(int hash, K key, V value, Entrance<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
