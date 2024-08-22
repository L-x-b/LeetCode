package com.yolo.leetcode._0011_container_with_most_water;

public class containerWithMostWater {

    /**
     * 让指针指向数组首位两端，然后不断向中间逼近，遍历所有元素
     */
    class Solution {
        public int maxArea(int[] height) {
            int head = 0, tail = height.length - 1;
            int res = 0;
            while (head < tail) {
                res = Math.max(res, (tail - head) * Math.min(height[head], height[tail]));
                if (height[head] > height[tail]) {
                    tail--;
                } else {
                    head++;
                }

            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new containerWithMostWater().new Solution();
        int[] height = {1,1};
//        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = solution.maxArea(height);
        System.out.println(i);
    }

}
