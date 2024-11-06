package com.yolo.leetcode._0101_symmetric_tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root, root);
        }

        public boolean isSymmetric(TreeNode u, TreeNode v) {
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.offer(u);
            q.offer(v);

            while (!q.isEmpty()) {
                u = q.poll();
                v = q.poll();
                if (u == null && v == null) {
                    continue;
                }
                if ((u == null || v == null) || (u.val != v.val)) {
                    return false;
                }
                q.offer(u.left);
                q.offer(v.right);
                q.offer(u.right);
                q.offer(v.left);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();

    }
}