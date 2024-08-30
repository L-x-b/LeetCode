package com.yolo.leetcode._0160_intersection_of_two_linked_lists;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 哈希表
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            HashSet<ListNode> set = new HashSet<>();
            while (headA != null) {
                set.add(headA);
                headA = headA.next;
            }
            while (headB != null) {
                if (set.contains(headB))
                    return headB;
            }
            return null;
        }
    }

    public static void main(String[] args) {

    }

}
