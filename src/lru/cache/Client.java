package lru.cache;

import lru.cache.strategy.LRUCache;

public class Client {

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");

        System.out.println(cache.get(1)); // Output: one
        System.out.println(cache.get(2)); // Output: two

        cache.put(4, "four"); // Evicts key 3 (least recently used)

        System.out.println(cache.get(3)); // Output: null (key 3 has been evicted)
        System.out.println(cache.get(4)); // Output: four
    }
}
