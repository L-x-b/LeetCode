package com.yolo.leetcode._0138_copy_list_with_random_pointer;

public class CopyListWithRandomPointer {


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return head;
            for (Node node = head; node != null; node = node.next.next) {
                Node newNode = new Node(node.val);
                newNode.next = node.next;
                node.next = newNode;
            }
            for (Node node = head; node != null; node = node.next.next) {
                Node newNode = node.next;
                newNode.random = (node.random != null) ? node.random.next : null;
            }
            Node headNew = head.next;
            for (Node node = head; node != null; node = node.next) {
                Node newNode = node.next;
                node.next = node.next.next;
                newNode.next = (newNode.next != null) ? newNode.next.next : null;
            }
            return headNew;
        }
    }

    public static void main(String[] args) {

    }

}
