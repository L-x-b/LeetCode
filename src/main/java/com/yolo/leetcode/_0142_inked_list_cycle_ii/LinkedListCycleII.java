package com.yolo.leetcode._0142_inked_list_cycle_ii;

public class LinkedListCycleII {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) return null;
            ListNode slow = head, fast = head;

            while (fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    return null;
                }
                if (slow == fast) {
                    ListNode ptr = head;
                    while (ptr != slow) {
                        slow = slow.next;
                        ptr = ptr.next;
                    }
                    return ptr;
                }
            }
            return null;


        }
    }

    public static void main(String[] args) {

    }

}
