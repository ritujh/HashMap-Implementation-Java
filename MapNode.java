public class MapNode<K,V>{
    K key;
    V value;
    MapNode<K,V> next;
    MapNode(K key, V val){
        this.key = key;
        this.value = val;
    }
}