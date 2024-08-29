package com.yolo.leetcode._0073_set_matrix_zeroes;

public class SetMatrixZeroes {

    class Solution {
        public void setZeroes(int[][] matrix) {
            int n = matrix.length, m = matrix[0].length;
            boolean flagRow0 = false;

            for (int i = 0; i < n; i++) {
                if (matrix[i][0] == 0) flagRow0 = true;

                for (int j = 1; j < m; j++) {
                    if (matrix[i][j] == 0) matrix[0][j] = matrix[i][0] = 0;
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = 1; j < m; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
                if (flagRow0) matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new SetMatrixZeroes().new Solution();
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints)
                System.out.print(anInt + " ");
            System.out.println();
        }
    }

}
