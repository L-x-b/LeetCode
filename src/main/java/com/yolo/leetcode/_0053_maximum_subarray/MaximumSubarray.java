package com.yolo.leetcode._0053_maximum_subarray;

public class MaximumSubarray {

    class Solution {
        public int maxSubArray(int[] nums) {
            int ans = nums[0];
            int pre = 0;

            for (int num : nums) {
                pre = Math.max(pre + num, num);
                ans = Math.max(ans, pre);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().new Solution().maxSubArray(nums));
    }

}
