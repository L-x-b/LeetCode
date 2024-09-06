package com.yolo.leetcode._0148_sort_list;

public class SortList {


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
     * 1. 计算链表长度
     * 2. 分组排序
     * 2.1 每次循环按照 1 2 4 8 的长度来切分链表
     * 2.2 将切分后的链表合并
     * 2.3 连接合并后的链表
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            int length = 0;

            ListNode node = head;
            while (node != null) {
                length++;
                node = node.next;
            }

            ListNode dummyHead = new ListNode(0, head);
            for (int subLength = 1; subLength < length; subLength <<= 1) {
                ListNode prev = dummyHead;
                ListNode curr = dummyHead.next;

                while (curr != null) {
                    // 切割链表，获得子链表1
                    ListNode head1 = curr;
                    for (int i = 1; curr.next != null && i < subLength; i++) {
                        curr = curr.next;
                    }
                    ListNode head2 = curr.next;
                    curr.next = null;
                    curr = head2;
                    // 切割链表，获得子链表2
                    for (int i = 1; curr != null && curr.next != null && i < subLength; i++) {
                        curr = curr.next;
                    }
                    ListNode next = null;
                    if (curr != null) {
                        next = curr.next;
                        curr.next = null;
                    }

                    // 合并链表


                    ListNode mergeNode = merge(head1, head2);
                    prev.next = mergeNode;

                    // 将prev移动到合并链表的末尾
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                    curr = next;
                }

            }
            return dummyHead.next;


        }

        ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead, temp1 = head1, temp2 = head2;

            while (temp1 != null && temp2 != null) {
                if (temp1.val < temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if (temp1 != null) {
                temp.next = temp1;
            }
            if (temp2 != null) {
                temp.next = temp2;
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {

    }

}
