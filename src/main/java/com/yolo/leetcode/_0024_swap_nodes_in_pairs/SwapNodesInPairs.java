package com.yolo.leetcode._0024_swap_nodes_in_pairs;

public class SwapNodesInPairs {

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
     * 递归
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;
            return newHead;
        }
    }

    public static void main(String[] args) {

    }
}
