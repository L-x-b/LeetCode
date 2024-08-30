package com.yolo.leetcode._0234_palindrome_linked_list;

public class PalindromeLinkedList {


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
        public boolean isPalindrome(ListNode head) {
            ListNode halfEnd = endOfFirstHalf(head);
            ListNode halfFirst = halfEnd.next;

            halfFirst = reverse(halfFirst);
            ListNode p = head, q = halfFirst;
            while (q != null) {
                if (q.val != p.val) return false;
                q = q.next;
                p = p.next;
            }
            return true;


        }

        public ListNode endOfFirstHalf(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public ListNode reverse(ListNode head) {
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
