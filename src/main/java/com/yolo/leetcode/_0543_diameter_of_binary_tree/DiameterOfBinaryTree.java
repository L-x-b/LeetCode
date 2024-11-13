package com.yolo.leetcode._0543_diameter_of_binary_tree;

public class DiameterOfBinaryTree {


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

        private int ans = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }

        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int lLen = depth(root.left);
            int rLen = depth(root.right);
            ans = Math.max(ans, lLen + rLen + 1);
            return Math.max(lLen, rLen) + 1;
        }
    }

    public static void main(String[] args) {

    }
}