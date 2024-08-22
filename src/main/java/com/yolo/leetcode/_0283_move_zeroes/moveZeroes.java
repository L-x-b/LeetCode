package com.yolo.leetcode._0283_move_zeroes;

public class moveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            int target = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[target++] = nums[i];
                    if (target - 1 != i) nums[i] = 0;
                }
            }


        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Solution solution = new moveZeroes().new Solution();
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }
}
