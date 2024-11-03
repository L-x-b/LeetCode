package com.yolo.leetcode._0001_two_sum;

public class twoSum {

    /**
     * 暴力解法
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int index1 = 0, index2 = index1 + 1;
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (target == nums[i] + nums[j]) {
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new twoSum().new Solution();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
