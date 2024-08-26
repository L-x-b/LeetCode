package com.yolo.leetcode._0239_sliding_window_maximum;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum_3 {

    /**
     * 单调队列
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> dq = new LinkedList<>();
            int n =nums.length;

            for (int i = 0; i < k; i++) {
                while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                    dq.pollLast();
                }
                dq.offerLast(i);
            }
            int[] ans = new int[n - k + 1];
            ans[0] = nums[dq.peekFirst()];
            for (int i = k; i < n; i++) {
                while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                    dq.pollLast();
                }
                dq.offerLast(i);
                while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                    dq.pollFirst();
                }
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = new SlidingWindowMaximum_3().new Solution().maxSlidingWindow(nums, 3);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
