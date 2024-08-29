package com.yolo.leetcode._0041_first_missing_positive;

public class FirstMissingPositive_2 {

    /**
     * 置换
     */
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
            for (int i = 0; i < n; ++i) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return n + 1;
        }
    }


    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive_2().new Solution();
        int[] nums = new int[]{3, 4, -1, 1};
        System.out.println(solution.firstMissingPositive(nums));

    }

}
