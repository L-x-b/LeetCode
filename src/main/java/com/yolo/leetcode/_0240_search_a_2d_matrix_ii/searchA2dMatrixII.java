package com.yolo.leetcode._0240_search_a_2d_matrix_ii;

public class searchA2dMatrixII {

    /**
     * 二分查找
     */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            for (int[] nums : matrix)
                if (search(nums, target) != -1)
                    return true;
            return false;
        }

        private int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new searchA2dMatrixII().new Solution();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean b = solution.searchMatrix(matrix, 5);
        System.out.println(b);

    }
}


