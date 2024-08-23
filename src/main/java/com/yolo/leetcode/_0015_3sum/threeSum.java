package com.yolo.leetcode._0015_3sum;

import java.util.*;

public class threeSum {
    /**
     * 遍历 + 排序 +两数之和（hashMap）
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                for (int j = i + 1; j < nums.length; j++) {
                    if (hashMap.containsKey(-nums[i] - nums[j])){
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j])));
                        while(j + 1 < nums.length && nums[j + 1] == nums[j]) j++;
                    }else {
                        hashMap.put(nums[j], j);
                    }

                }
                while(i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
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
