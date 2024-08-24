package com.yolo.leetcode._0042_trapping_rain_water;

import java.util.Deque;
import java.util.LinkedList;

public class trappingRainWater_5 {


    /**
     * 双指针
     */
    class Solution {
        public int trap(int[] height) {
            int left = 0, right = height.length -1 ;
            int maxLeft = 0, maxRigth = 0;
            int ans = 0;

            while (left < right) {
                maxLeft = Math.max(maxLeft, height[left]);
                maxRigth = Math.max(maxRigth, height[right]);
                if (height[left] < height[right]) {
                    ans += maxLeft - height[left];
                    left ++;
                }else {
                    ans += maxRigth - height[right];
                    right --;
                }
            }
            return ans;

        }
    }

    public static void main(String[] args) {
        Solution solution = new trappingRainWater_5().new Solution();

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] height = {4, 2, 0, 3, 2, 5};


        int trap = solution.trap(height);
        System.out.println(trap);
    }

}
