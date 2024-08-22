package com.yolo.leetcode._0015_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) break; // 如果当前数大于0，则三数之和不可能等于0
                if (i > 0 && nums[i - 1] == nums[i]) continue; // 去重
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum > 0) right--;
                    else if (sum < 0) left++;
                    else {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
            }
            return res;

        }
    }

    public static void main(String[] args) {
        Solution solution = new threeSum().new Solution();

        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = solution.threeSum(nums);
        for (List<Integer> list : lists) {
            list.forEach(item -> System.out.print(item + " "));
            System.out.println();
        }
    }
}
