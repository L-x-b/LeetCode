package com.yolo.leetcode._0042_trapping_rain_water;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class trappingRainWater_4 {


    /**
     * 单调栈
     */
    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    int left = stack.peek();
                    int currWidth = i - left - 1;
                    int currHeight = Math.min(height[left], height[i]) - height[top];
                    ans += currWidth * currHeight;

                }
                stack.push(i);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new trappingRainWater_4().new Solution();

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] height = {4, 2, 0, 3, 2, 5};


        int trap = solution.trap(height);
        System.out.println(trap);
    }

}
