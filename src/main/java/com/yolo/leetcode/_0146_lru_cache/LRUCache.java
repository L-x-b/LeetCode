package com.yolo.leetcode._0146_lru_cache;


import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DlinkNode {
        int key;
        int value;
        DlinkNode prev;
        DlinkNode next;

        public DlinkNode() {
        }

        public DlinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DlinkNode> cache = new HashMap<>();
    int size = 0;
    int capacity = 0;
    private DlinkNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DlinkNode();
        tail = new DlinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DlinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DlinkNode node = cache.get(key);
        if (node == null) {
            DlinkNode newNode = new DlinkNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DlinkNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void addToHead(DlinkNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void removeNode(DlinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DlinkNode removeTail() {
        DlinkNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public void moveToHead(DlinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}





