package com.yolo.leetcode._0041_group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class groupAnagrams_3 {
    /**
     * 通过stream流，分组排序
     * 通过编码，将[b,a,a,a,b,c]编码为 a3b2c1，以此作为分类依据
     */

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
                // 记录每个字符串字符出现的次数
                int[] counts = new int[26];
                for (int i = 0; i < str.length(); i++) {
                    counts[str.charAt(i) - 'a']++;
                }
                // 编码
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < counts.length; i++) {
                    if (counts[i] != 0) {
                        stringBuffer.append((char) ('a' + i)).append(counts[i]);
                    }

                }
                return stringBuffer.toString();

            })).values());
        }
    }


    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {""};
//        String[] strs = {"a"};
        Solution solution = new groupAnagrams_3().new Solution();
        List<List<String>> lists = solution.groupAnagrams(strs);
        System.out.println(lists);


    }


}


