package com.yolo.leetcode._0206_reverse_linked_list;

public class ReverseLinkedList {


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
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode i = head.next;
            ListNode j = i.next;
            head.next = null;
            while (i != null) {
                i.next = head;
                head = i;
                i = j;
                if (j != null) j = j.next;
            }
            return head;
        }
    }

    public static void main(String[] args) {

    }

}
