package lru.cache;

import lru.cache.interfaces.Cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> implements Cache<K,V> {

        private Map<K, DoublyLinkedList.Node<K,V>> map;
        private DoublyLinkedList<K,V> list;
        private int capacity;

        public LRUCache(int capacity) {
                this.map = new HashMap<>(capacity);
                this.list = new DoublyLinkedList<>();
                this.capacity = capacity;

        }

        @Override
        synchronized public void put(K key, V value) {
            if(map.containsKey(key)){
                DoublyLinkedList.Node<K,V> node = map.get(key);
                node.value = value;
                list.removeNode(node);
                list.addFirst(node);
            }else{
                if(map.size() >= capacity){
                    DoublyLinkedList.Node<K,V> node = list.removeLast();
                    if(node!=null)
                        map.remove(node.key);
                }
                map.put(key, list.addFirst(key, value));
            }
        }

        @Override
        synchronized public V get(K key) {
            if(map.containsKey(key)){
                DoublyLinkedList.Node<K,V> node = map.get(key);
                list.removeNode(node);
                list.addFirst(node);
                return node.value;
            }
            return null;
        }

        @Override
        synchronized public void remove(K key) {
            if(map.containsKey(key)){
                DoublyLinkedList.Node<K,V> node = map.get(key);
                list.removeNode(node);
                map.remove(key);
            }
        }

        @Override
        public boolean containsKey(K key) {
            return map.containsKey(key);
        }

        @Override
        public int size() {
            return map.size();
        }
}
