package com.yolo.leetcode._0240_search_a_2d_matrix_ii;

public class searchA2dMatrixII_2 {

    /**
     * z字查找
     */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length, m = matrix[0].length;
            int x = 0, y = m - 1;

            while (x < n && y >= 0) {
                if (matrix[x][y] == target) return true;
                if (target > matrix[x][y]) {
                    x ++;
                }else {
                    y--;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new searchA2dMatrixII_2().new Solution();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean b = solution.searchMatrix(matrix, 5);
        System.out.println(b);

    }
}


