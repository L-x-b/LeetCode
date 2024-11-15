package com.yolo.leetcode._0098_validate_binary_search_tree;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree2 {

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

    /**
     * 通过中序遍历的方式，每次判断根节点是否大于上一个节点
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;

            Deque<TreeNode> deque = new LinkedList();
            double inOrder = -Double.MAX_VALUE;

            while (!deque.isEmpty() || root != null) {
                while (root != null) {
                    deque.push(root);
                    root = root.left;
                }
                root = deque.pop();
                if (root.val <= inOrder) return false;
                inOrder = root.val;
                root = root.right;
            }
            return true;
        }
    }

    public static void main(String[] args) {

    }
}