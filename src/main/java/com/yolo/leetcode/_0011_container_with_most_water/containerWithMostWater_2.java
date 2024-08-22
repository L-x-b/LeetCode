package com.yolo.leetcode._0011_container_with_most_water;

import com.sun.org.apache.bcel.internal.generic.RET;

public class containerWithMostWater_2 {

    /**
     * 让指针指向数组首位两端，左右指针不断向中间寻找比前一个挡板高的位置，这样能够减少计算面积的次数
     */
    class Solution {
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int res = 0;
            while (left < right) {
                int high = Math.min(height[right], height[left]);
                res = Math.max(res, (right - left) * high);
                while (left < right && high >= height[left]) left++;
                while (left < right && high >= height[right]) right--;
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution solution = new containerWithMostWater_2().new Solution();
//        int[] height = {1, 1};
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = solution.maxArea(height);
        System.out.println(i);
    }

}
