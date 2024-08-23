package com.yolo.leetcode._0283_move_zeroes;

public class moveZeroes_2 {
    /**
     * 通过将非0位置的数字与0所在的位置进行交换
     */
    class Solution {
        public void moveZeroes(int[] nums) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i++] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Solution solution = new moveZeroes_2().new Solution();
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }
}
