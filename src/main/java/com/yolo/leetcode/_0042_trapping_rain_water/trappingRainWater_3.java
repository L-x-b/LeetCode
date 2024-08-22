package com.yolo.leetcode._0042_trapping_rain_water;

public class trappingRainWater_3 {


    /**
     * 按列求
     * 分别找出左右两边最高的墙，当前列的水容量=max(0,min(left,right)-height[cur])
     * 由于每次都需要遍历找出左右两端的最大值，采用动态规划来优化算法
     * left[i] = max(left[i-1],left[i-1])
     * right[i] = max(right[i+1],right[i+1])
     */
    class Solution {
        public int trap(int[] height) {
            int sum = 0;

            int[] leftWall = new int[height.length];
            int[] rightWall = new int[height.length];

            leftWall[0] = height[0];
            rightWall[height.length - 1] = height[height.length - 1];

            for (int i = 1; i < leftWall.length; i++) {
                leftWall[i] = Math.max(leftWall[i - 1], height[i - 1]);
            }
            for (int i = rightWall.length - 2; i >= 0; i--) {
                rightWall[i] = Math.max(rightWall[i + 1], height[i + 1]);
            }


            //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
            for (int i = 1; i < height.length - 1; i++) {
                sum += Math.max(0, Math.min(leftWall[i], rightWall[i]) - height[i]);
            }
            return sum;
        }


    }

    public static void main(String[] args) {
        Solution solution = new trappingRainWater_3().new Solution();

//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {4, 2, 0, 3, 2, 5};


        int trap = solution.trap(height);
        System.out.println(trap);
    }

}
