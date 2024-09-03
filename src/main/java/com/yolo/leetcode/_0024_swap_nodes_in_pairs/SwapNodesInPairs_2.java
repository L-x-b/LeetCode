package com.yolo.leetcode._0024_swap_nodes_in_pairs;

public class SwapNodesInPairs_2 {

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

    /**
     * 迭代
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummp = new ListNode(0, head);
            ListNode temp = dummp;
            while (temp.next != null && temp.next.next != null) {
                ListNode node1 = temp.next;
                ListNode node2 = temp.next.next;

                temp.next = node2;
                node1.next = node2.next;
                node2.next = node1;
                temp = node1;
            }
            return dummp.next;
        }
    }

    public static void main(String[] args) {

    }
}
