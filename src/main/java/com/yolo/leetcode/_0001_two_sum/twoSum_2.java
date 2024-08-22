package com.yolo.leetcode._0001_two_sum;


import java.util.HashMap;

public class twoSum_2 {

    /**
     * 通过HashMap 优化时间
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {

                if (hashMap.containsKey(target - nums[i])) {
                    return new int[]{hashMap.get(target - nums[i]), i};
                } else {
                    hashMap.put(nums[i], i);
                }
            }
            return new int[0];
        }
    }

    public static void main(String[] args) {
        Solution solution = new twoSum_2().new Solution();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
