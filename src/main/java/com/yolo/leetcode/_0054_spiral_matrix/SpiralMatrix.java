package com.yolo.leetcode._0054_spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix.length == 0) return new ArrayList<>();
            int l = 0, t = 0, r = matrix[0].length - 1, b = matrix.length - 1;
            List<Integer> ans = new ArrayList<>();
            while(true) {
                for (int i = l; i <= r; i++) ans.add(matrix[t][i]);
                if (++t > b) break;
                for (int i = t; i <= b; i++) ans.add(matrix[i][r]);
                if (--r < l) break;
                for (int i = r; i >= l; i--) ans.add(matrix[b][i]);
                if (--b < t) break;
                for (int i = b; i >= t; i--) ans.add(matrix[i][l]);
                if (++l > r) break;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Solution solution = new SpiralMatrix().new Solution();
        List<Integer> ans = solution.spiralOrder(matrix);
        System.out.println(ans);
    }

}
