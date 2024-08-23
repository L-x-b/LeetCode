package com.yolo.leetcode._0015_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class threeSum_2 {
    /**
     * 遍历 + 排序 + 双指针
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            // 排序
            Arrays.sort(nums);
            // 第一遍遍历
            for (int first = 0; first < nums.length; first++) {
                // 去重
                if (first > 0 && nums[first - 1] == nums[first]) continue;
                int target = -nums[first];
                int third = nums.length - 1;
                // 双指针遍历
                for (int second = first + 1; second < nums.length; second++) {
                    // 去重
                    if (second > first + 1 && nums[second - 1] == nums[second]) continue;
                    // second + third > target 则缩小 third
                    while (second < third && nums[second] + nums[third] > target) third--;
                    if (second == third) break;
                    if (nums[second] + nums[third] == target) {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[first], nums[second], nums[third])));
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new threeSum_2().new Solution();

        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = solution.threeSum(nums);
        for (List<Integer> list : lists) {
            list.forEach(item -> System.out.print(item + " "));
            System.out.println();
        }
    }
}
