package com.yolo.leetcode._0042_trapping_rain_water;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;

public class trappingRainWater {

    /**
     * 整个思路就是，求第 i 层的水，遍历每个位置，
     * 如果当前的高度小于 i，并且两边有高度大于等于 i 的，说明这个地方一定有水，水就可以加 111。
     * leetcode中没办法ac，超出限制时间
     */
    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int max = Arrays.stream(height).max().getAsInt();
            for (int row = 1; row <= max; row++) {
                ans += trapByRow(height, row);
            }
            return ans;
        }

        private int trapByRow(int[] height, int row) {
            if (height.length < 2) return 0;
            int ans = 0;
            int left = 0, right = 1;
            while (left < height.length - 1) {
                if (right >= height.length - 1) break;
                if (height[left] < row) {
                    left++;
                    continue;
                }
                right = left + 1;
                while (right < height.length) {
                    if (height[right] < row) {
                        right++;
                        continue;
                    }
                    ans += right - left - 1;
                    left = right;
                    break;
                }

            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new trappingRainWater().new Solution();

//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {4, 2, 0, 3, 2, 5};
        

        int trap = solution.trap(height);
        System.out.println(trap);
    }

}
