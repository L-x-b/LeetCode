package com.yolo.leetcode._0025_reverse_nodes_in_k_group;

public class ReverseNodesInKGroup {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummp = new ListNode(0, head);
            ListNode pre = dummp;

            while (head != null) {
                ListNode tail = pre;
                for (int i = 0; i < k; i++) {
                    tail = tail.next;
                    if (tail == null) return dummp.next;
                }
                ListNode nex = tail.next;
                ListNode[] reverse = myReverse(head, tail);
                head = reverse[0];
                tail = reverse[1];

                pre.next = head;
                tail.next = nex;
                pre = tail;
                head = tail.next;
            }
            return dummp.next;
        }

        public ListNode[] myReverse(ListNode head, ListNode tail) {
            ListNode prev = tail.next;
            ListNode p = head;
            while (prev != tail) {
                ListNode nex = p.next;
                p.next = prev;
                prev = p;
                p = nex;
            }
            return new ListNode[]{tail, head};
        }
    }

    public static void main(String[] args) {

    }

}
