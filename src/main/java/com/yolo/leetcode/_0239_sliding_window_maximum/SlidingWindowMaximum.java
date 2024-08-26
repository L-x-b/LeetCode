package com.yolo.leetcode._0239_sliding_window_maximum;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {

    /**
     * 暴力解法
     * 运行超时！！！
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] ans = new int[nums.length - k + 1];
            int start = 0, end = start + k - 1;
            int maxIndex = 0;
            int max = nums[0];

            for (int i = start + 1; i <= end; i++) {
                if (max < nums[i]) {
                    maxIndex = i;
                    max = nums[i];
                }
            }
            while (end < nums.length) {
                if (start > maxIndex) {
                    maxIndex = start;
                    max = nums[start];
                    for (int i = start + 1; i <= end; i++) {
                        if (max < nums[i]) {
                            maxIndex = i;
                            max = nums[i];
                        }
                    }
                }
                ans[start] = max;
                start++;
                end++;
                if (end < nums.length && max < nums[end]) {
                    maxIndex = end;
                    max = nums[end];
                }
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = new SlidingWindowMaximum().new Solution().maxSlidingWindow(nums, 3);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
