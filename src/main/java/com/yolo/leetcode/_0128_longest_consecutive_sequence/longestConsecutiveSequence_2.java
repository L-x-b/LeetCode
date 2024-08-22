package com.yolo.leetcode._0128_longest_consecutive_sequence;

import java.util.Arrays;
import java.util.HashSet;

public class longestConsecutiveSequence_2 {

    /**
     * 通过哈希表来实现
     */
    class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }
            int longestStreak = 0;
            for (Integer num : numSet) {
                if (!numSet.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while (numSet.contains(currentNum + 1)) {
                        currentStreak++;
                        currentNum++;
                    }
                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }
            return longestStreak;

        }
    }

    public static void main(String[] args) {
        Solution solution = new longestConsecutiveSequence_2().new Solution();

//        int[] nums = {100, 4, 200, 1, 3, 2};
//        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums = {1, 2, 0, 1};

        int i = solution.longestConsecutive(nums);
        System.out.println(i);
    }
}
