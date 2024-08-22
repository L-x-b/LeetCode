package com.yolo.leetcode._0560_subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

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
public class SubarraySumEqualsK_4 {
    /**
     * 前缀和+哈希表优化
     * 由于最后的答案只跟前缀和组数有关，问题可以转变为求两数之和，求preSum - (preSum - k] == k)
     * 时间复杂度：O(n)
     */
    class Solution {
        public int subarraySum(int[] nums, int k) {

            Map<Integer, Integer> preSumFreq = new HashMap<>();
            int preSum = 0;
            int count = 0;
            preSumFreq.put(0, 1);


            for (int num : nums) {
                preSum += num;
                if (preSumFreq.containsKey(preSum - k)) {
                    count += preSumFreq.get(preSum - k);
                }

                // 维护preSumFreq的个数
                preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
            }
            return count;

        }
    }


    public static void main(String[] args) {

        Solution solution = new SubarraySumEqualsK_4().new Solution();

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
