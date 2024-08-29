package com.yolo.leetcode._0041_first_missing_positive;

public class FirstMissingPositive {

    /**
     * 哈希表
     */
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0) nums[i] = n + 1;
            }
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                if (num <= n) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) return i + 1;
            }
            return n + 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        int[] nums = new int[]{1, 2, 0};
        System.out.println(solution.firstMissingPositive(nums));

    }

}
