package com.yolo.leetcode._0056_merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {

            if (intervals.length == 0) {
                return new int[0][2];
            }

            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            List<int[]> merge = new ArrayList<>();

            for (int[] interval : intervals) {
                int left = interval[0];
                int right = interval[1];
                if (merge.isEmpty() || merge.get(merge.size() - 1)[1] < left) {
                    merge.add(interval);
                }else {
                    merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], right);
                }
            }
            return merge.toArray(new int[merge.size()][]);
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = new MergeIntervals().new Solution().merge(intervals);
        for (int[] interval : merge)
            System.out.println(Arrays.toString(interval));
    }

}
