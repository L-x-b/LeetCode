package com.yolo.leetcode._0293_sliding_window_maximum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目描述：
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 */
public class SlidingWindowMaximum {

    /**
     * 暴力解法：
     *      对每个区间排序，取出第一个值就是最大值
     * 超出时间限制
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            int left = 0, right = k - 1;

            int[] ans = new int[nums.length - k + 1];

            while (right < nums.length) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(nums[i]);
                }
                list.sort((a, b) -> {
                    return b - a;
                });
                ans[left] = list.get(0);
                left++;
                right++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;


        int[] res = solution.maxSlidingWindow(nums, k);
        for (int re : res) {
            System.out.println(re);
        }
    }

}
