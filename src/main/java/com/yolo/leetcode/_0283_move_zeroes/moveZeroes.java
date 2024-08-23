package com.yolo.leetcode._0283_move_zeroes;

public class moveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            // 1. 找到第一个为零的数
            int index1 = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    index1 = i;
                    break;
                }
            }
            // 如果没有找到则表述不需要移动，直接返回
            if (index1 == -1) return;
            // 2. 移动后面所有非0的数
            for (int i = index1 + 1; i < nums.length; i++) {
                if (nums[i] == 0) continue;
                nums[index1++] = nums[i];
            }
            // 3. 将尾部填充0
            for (int i = index1; i < nums.length; i++) {
                nums[i] = 0;
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
