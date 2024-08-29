package com.yolo.leetcode._0048_rotate_image;

public class RotateImage {

    /**
     * 1. 先上下翻转
     * 2. 再对角线翻转
     */
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int temp;
            // 水平翻转
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - i][j];
                    matrix[n - 1 - i][j] = temp;
                }
            }
            // 对角线翻转
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new RotateImage().new Solution().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

}
