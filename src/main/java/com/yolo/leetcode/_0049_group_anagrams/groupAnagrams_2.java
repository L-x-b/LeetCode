package com.yolo.leetcode._0049_group_anagrams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

public class groupAnagrams_2 {

    /**
     * 使用每个单词的出现次数作为key
     */
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                int[] counts = new int[26];
                for (int i = 0; i < str.length(); i++) {
                    counts[str.charAt(i) - 'a']++;
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < counts.length; i++) {
                    if (counts[i] != 0) {
                        stringBuffer.append((char) ('a' + i));
                        stringBuffer.append(counts[i]);
                    }
                }
                String key = stringBuffer.toString();
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }
    }

    public static void main(String[] args) {
        Solution solution = new groupAnagrams_2().new Solution();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> lists = solution.groupAnagrams(strs);
        System.out.println(lists);
    }

}
