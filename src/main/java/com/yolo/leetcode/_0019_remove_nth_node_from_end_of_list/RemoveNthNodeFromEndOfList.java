package com.yolo.leetcode._0019_remove_nth_node_from_end_of_list;

public class RemoveNthNodeFromEndOfList {


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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode first = head;
            ListNode second = dummy;

            for (int i = 0; i < n; i++) {
                first = first.next;
            }
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return dummy.next;
        }
    }

    public static void main(String[] args) {

    }

}
