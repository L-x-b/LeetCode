package com.yolo.leetcode._0128_longest_consecutive_sequence;

import java.util.Arrays;

public class longestConsecutiveSequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) return 0;

            int count_max = 0, count = 1;
            Arrays.sort(nums);
            int target = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // 判断当前数字是否与前一个数字重复
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
                target++;
                if (nums[i] == target) {
                    count++;
                } else {
                    target = nums[i];
                    count_max = Math.max(count_max, count);
                    count = 1;
                }
            }
            count_max = Math.max(count_max, count);

            return count_max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new longestConsecutiveSequence().new Solution();

//        int[] nums = {100, 4, 200, 1, 3, 2};
//        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums = {1, 2, 0, 1};

        int i = solution.longestConsecutive(nums);
        System.out.println(i);
    }
}
