package com.yolo.leetcode._0023_merge_k_sorted_lists;

import java.util.PriorityQueue;

public class MergeKSortedLists {


    class ListNode {
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

    class Status implements Comparable<Status> {

        int val;

        ListNode ptr;

        public Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }

    /**
     * 使用优先队列合并
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            PriorityQueue<Status> queue = new PriorityQueue<>();

            for (ListNode list : lists) {
                if (list != null) {
                    queue.offer(new Status(list.val, list));
                }
            }
            ListNode head = new ListNode(0);
            ListNode tail = head;

            while (!queue.isEmpty()) {
                Status f = queue.poll();
                tail.next = f.ptr;
                tail = tail.next;
                if (f.ptr.next != null) {
                    queue.offer(new Status(f.ptr.next.val, f.ptr.next));
                }

            }

            return head.next;
        }
    }

    public static void main(String[] args) {

    }
}
