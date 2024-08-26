package com.yolo.leetcode._0239_sliding_window_maximum;

import java.util.PriorityQueue;

public class SlidingWindowMaximum_2 {

    /**
     * 优先队列
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] ans = new int[nums.length - k + 1];
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);

            for (int i = 0; i < k; i++) {
                pq.offer(new int[]{nums[i], i});
            }
            ans[0] = pq.peek()[0];
            for (int i = k; i < nums.length; i++) {
                pq.offer(new int[]{nums[i], i});
                while (pq.peek()[1] <= i - k)
                    pq.poll();
                ans[i - k + 1] = pq.peek()[0];
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = new SlidingWindowMaximum_2().new Solution().maxSlidingWindow(nums, 3);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
