package com.yolo.leetcode._0226_invert_binary_tree;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class InvertBinaryTree {


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
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>() {{
                add(root);
            }};
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }

            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
    }
}

