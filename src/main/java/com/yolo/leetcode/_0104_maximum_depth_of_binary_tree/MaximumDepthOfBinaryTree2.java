package com.yolo.leetcode._0104_maximum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree2 {
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
         * 广度优先遍历
         *
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int ans = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    size--;
                }
                ans++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree2().new Solution();

    }
}