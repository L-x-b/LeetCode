package com.yolo.leetcode._0189_rotate_array;

public class RotateArray {
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n -1);
        }
        public void reverse(int[] nums, int start, int end) {
            int temp;
            while (start < end) {
                temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start ++;
                end --;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Solution solution = new RotateArray().new Solution();
        solution.rotate(nums, k);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
