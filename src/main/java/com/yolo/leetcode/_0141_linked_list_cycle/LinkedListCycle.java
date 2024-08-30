package com.yolo.leetcode._0141_linked_list_cycle;

public class LinkedListCycle {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {

    }

}
