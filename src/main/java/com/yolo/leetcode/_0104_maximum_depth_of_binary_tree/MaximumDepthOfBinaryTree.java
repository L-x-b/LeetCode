package com.yolo.leetcode._0104_maximum_depth_of_binary_tree;

public class MaximumDepthOfBinaryTree {
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
        /**
         * 深度优先遍历
         *
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftDepth = maxDepth(root.left);
                int rightDepth = maxDepth(root.right);
                return Math.max(leftDepth, rightDepth) + 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();

    }
}