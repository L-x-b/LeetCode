package com.yolo.leetcode._0076_minimum_window_substring;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinimumWindowSubstring {

    class Solution {
        HashMap<Character, Integer> ori = new HashMap<>();
        HashMap<Character, Integer> cut = new HashMap<>();

        public String minWindow(String s, String t) {

            int l = 0, r = -1;
            int ansL = -1, ansR = -1, len = Integer.MAX_VALUE;
            int sLen = s.length(), tLen = t.length();
            for (int i = 0; i < tLen; i++) {
                char c = t.charAt(i);
                ori.put(c, ori.getOrDefault(c, 0) + 1);
            }
            while (r < sLen) {
                r ++;
                if (r < sLen && ori.containsKey(s.charAt(r))) {
                    cut.put(s.charAt(r), cut.getOrDefault(s.charAt(r), 0) + 1);
                }
                while (check() && l <= r) {
                    if (r - l + 1 < len) {
                        len = r - l + 1;
                        ansL = l;
                        ansR = l + len;
                    }
                    if (ori.containsKey(s.charAt(l))) {
                        cut.put(s.charAt(l), cut.getOrDefault(s.charAt(l), 0) - 1);
                    }
                    l ++;
                }
            }
            return ansL == -1 ? "" : s.substring(ansL, ansR);
        }

        public boolean check() {
            Iterator iter = ori.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Character key = (Character) entry.getKey();
                Integer value = (Integer) entry.getValue();
                if (cut.getOrDefault(key, 0) < value) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));

    }

}
