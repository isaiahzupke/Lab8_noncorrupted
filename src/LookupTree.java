import java.util.*;

public class LookupTree<K extends Comparable<? super K>, V> implements Map<K, V> {

    private ArrayList<Entry<K, V>> data = new ArrayList<>();

    private static class Entry<K extends Comparable<? super K>, V>
            implements Comparable<Entry<K, V>>, Map.Entry<K, V> {

        K key;
        V value;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Entry<K, V> object) {
            return this.key.compareTo(object.key);
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V previousValue = this.value;
            this.value = value;
            return previousValue;
        }
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        boolean found = false;
        int pos = Collections.binarySearch(data, new Entry<>((K) key, null));
        found = (pos >= 0);
        return found;
    }

    @Override
    public V get(Object key) {
        V returnElement = null;
        int pos = Collections.binarySearch(data, new Entry<>((K) key, null));
        if(pos >= 0){
            returnElement = data.get(pos).value;
        }
        return returnElement;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public V put(K key, V value) {
        V previousElement = null;
        int pos = Collections.binarySearch(data, new Entry<>((K) key, null));
        if(pos >= 0){
            previousElement = data.get(pos).setValue(value);
        } else {
            data.add(-pos, new Entry<>((K) key, value));//POTENTIALLY NEED TO ADD A MINUS ONE
        }
        return previousElement;
    }

    @Override
    public V remove(Object key) {
        V previousElement = null;
        int pos = Collections.binarySearch(data, new Entry<>((K) key, null));
        if(pos >= 0){
            previousElement = data.remove(pos).value;
        }
        return previousElement;
    }

    @Override
    public int size() {
        return data.size();
    }









    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException("not implemented yet");
    }



    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
