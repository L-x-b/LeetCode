package com.yolo.leetcode._0238_product_of_array_except_self;

public class ProductOfArrayExceptSelf {

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];

            ans[0] = 1;
            for (int i = 1; i < n; i++) {
                ans[i] = nums[i - 1] * ans[i - 1];
            }

            int R = 1;
            for (int i = n - 1; i >= 0; i--) {
                ans[i] *= R;
                R = nums[i] * R;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
        int[] nums = {1,2,3,4};
        int[] result = solution.productExceptSelf(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }


}
