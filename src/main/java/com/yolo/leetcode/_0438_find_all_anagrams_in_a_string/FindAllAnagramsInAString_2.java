package com.yolo.leetcode._0438_find_all_anagrams_in_a_string;

import java.util.*;
import java.util.stream.Stream;


public class FindAllAnagramsInAString_2 {


    /**
     * 滑动窗口
     */
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int sLen = s.length(), pLen = p.length();
            if (sLen < pLen) {
                return new ArrayList<>();
            }

            int[] sCount = new int[26];
            int[] pCount = new int[26];
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < pLen; i++) {
                sCount[s.charAt(i) - 'a'] ++;
                pCount[p.charAt(i) - 'a'] ++;
            }

            for (int i = 0; i < sLen - pLen + 1; i++) {
                if (Arrays.equals(pCount,sCount)) {
                    ans.add(i);
                }
                sCount[s.charAt(i) - 'a'] --;
                sCount[s.charAt(i + pLen - 1) - 'a'] ++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString_2().new Solution();

        String s = "abab";
        String p = "ab";
        List<Integer> anagrams = solution.findAnagrams(s, p);
        for (Integer anagram : anagrams) {
            System.out.println(anagram);
        }


    }

}
