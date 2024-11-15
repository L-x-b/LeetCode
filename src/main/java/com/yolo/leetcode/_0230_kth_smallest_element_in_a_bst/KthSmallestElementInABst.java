package com.yolo.leetcode._0230_kth_smallest_element_in_a_bst;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallestElementInABst {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> deque = new LinkedList();

            while (!deque.isEmpty() || root != null) {
                while (root != null) {
                    deque.push(root);
                    root = root.left;
                }
                root = deque.pop();
                if (--k == 0) return root.val;
                root = root.right;
            }
            return 0;
        }
    }
}