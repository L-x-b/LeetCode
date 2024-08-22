package com.yolo.leetcode._0438_find_all_anagrams_in_a_string;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FindAllAnagramsInAString {

    /**
     * 遍历每个字符串，依次与p进行比对，判断是否为异构词
     * 时间超时
     */
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < s.length() - p.length() + 1; i++) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int j = 0; j < p.length(); j++) {
                    stringBuffer.append(s.charAt(i + j));
                }
                if (isAnagrams(stringBuffer.toString(), p)) ans.add(i);
            }

            return ans;
        }

        public boolean isAnagrams(String s, String p) {

            char[] sCharArray = s.toCharArray();
            char[] pCharArray = p.toCharArray();
            Arrays.sort(sCharArray);
            Arrays.sort(pCharArray);
            return String.valueOf(sCharArray).equals(String.valueOf(pCharArray));
        }
    }

    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();

        String s = "abab";
        String p = "ab";

        List<Integer> anagrams = solution.findAnagrams(s, p);
        for (Integer anagram : anagrams) {
            System.out.println(anagram);
        }


    }

}
