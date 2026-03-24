package lru.cache;

import org.w3c.dom.Node;

public class DoublyLinkedList<K,V> {

    private Node<K,V> head;
    private Node<K,V> tail;
    private int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public Node<K,V> addFirst(Node<K,V> node){
        node.prev = null;
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node;
    }

    public Node<K,V> addFirst(K key, V value){
        Node<K,V> newNode = new Node<>(key,value);
        return addFirst(newNode);
    }

    public Node<K,V> removeNode(Node<K,V> node){
        if(node==null) return null;
        if(node==tail)return removeLast();
        if(node==head){return removeHead();}
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev=null;
        node.next=null;
        return node;
    }

    private Node<K,V> removeHead(){
        if(head==null) return null;
        Node<K,V> node = head;
        if(head==tail) {
            head = null;
            tail = null;
            return node;
        }
        head = head.next;
        head.prev = null;
        node.next = null;
        return node;
    }

    public Node<K, V> removeLast(){
        if(head == null){return null;}
        if(head == tail) {
            Node<K,V> temp = head;
            head = null;
            tail = null;
            return temp;
        }
        Node<K,V> temp = tail;
        tail = tail.prev;
        tail.next = null;
        return temp;
    }


     public static class Node<K,V>{
        K key;
        V value;
        Node<K,V> prev;
        Node<K,V> next;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

    }
}
