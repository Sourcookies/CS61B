package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private Node root;
    private int size;

    private class Node{
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    };

    public BSTMap(){
        this.size = 0;
    }
    private Node clear(Node node){
        if (node == null){
            return null;
        }
        node.left = clear(node.left);
        node.right = clear(node.right);
        return null;
    }
    @Override
    public void clear(){
        root = clear(root);
        this.size = 0;
    }
    @Override
    public boolean containsKey(K key){
        if (key == null){
            throw new IllegalArgumentException("a null key");
        }
        return get(root, key) != null;

    }
    private Node get(Node node, K key){
        if (node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            return get(node.left, key);
        }else if (cmp > 0){
            return get(node.right, key);
        }else {
            return node;
        }
    }
    public V get(K key){
        if (key == null){
            throw new IllegalArgumentException("a null key");
        }
        Node node = get(root, key);
        if (node == null){
            return null;
        }else {
            return node.value;
        }
    }
    public int size(){
        return this.size;
    }

    private Node put(Node node, K key, V value){
        if (node == null){
            this.size += 1;
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.left = put(node.left, key, value);
        } else if (cmp > 0){
            node.right = put(node.right, key, value);
        } else{
            node.value = value;
        }
        return node;
    }

    public void put(K key, V value){
        if (key == null){
            throw new IllegalArgumentException("a null key");
        }
        root = put(root, key, value);
    }
    public Set<K> keySet(){
        throw new UnsupportedOperationException();
    }
    public V remove(K key){
        throw new UnsupportedOperationException();
    }
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }
    public Iterator<K> iterator(){
        throw new UnsupportedOperationException();
    }
    public void printInOrder(){

    }
}
