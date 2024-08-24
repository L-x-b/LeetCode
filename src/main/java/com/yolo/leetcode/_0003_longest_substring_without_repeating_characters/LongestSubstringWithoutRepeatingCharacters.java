package com.yolo.leetcode._0003_longest_substring_without_repeating_characters;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> occ = new HashSet<>();
            int rk = -1;
            int n = s.length();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    occ.remove(s.charAt(i - 1));
                }

                while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                    occ.add(s.charAt(rk + 1));
                    rk++;
                }

                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "abcabcbb";
        int res = solution.lengthOfLongestSubstring(s);
        System.out.println(res);
    }

}
