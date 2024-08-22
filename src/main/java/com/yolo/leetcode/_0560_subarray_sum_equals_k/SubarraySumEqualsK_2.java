package com.yolo.leetcode._0560_subarray_sum_equals_k;

/**
 * 题目描述：
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class SubarraySumEqualsK_2 {
    /**
     * 暴力解法（优化）：
     * 固定左端点，依次向后累加，寻找符合条件的情况
     * 时间复杂度：O(n^2)
     */
    class Solution {
        public int subarraySum(int[] nums, int k) {

            int ans = 0;
            for (int left = 0; left < nums.length; left++) {
                int sum = 0;
                for (int right = left; right < nums.length; right++) {
                    sum += nums[right];
                    if (sum == k) {
                        ans++;
                    }
                }
            }
            return ans;

        }
    }


    public static void main(String[] args) {

        Solution solution = new SubarraySumEqualsK_2().new Solution();

//        int[] nums = {1, 1, 1};
//        int k = 2;
//        int[] nums = {1, 2, 3};
//        int k = 3;
        int[] nums = {1, -1, 0};
        int k = 0;

        int i = solution.subarraySum(nums, k);
        System.out.println(i);
    }

}