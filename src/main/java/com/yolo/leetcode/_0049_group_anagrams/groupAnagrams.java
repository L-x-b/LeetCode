package com.yolo.leetcode._0049_group_anagrams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

public class groupAnagrams {

    /**
     * 使用每个单词排序后的形式作为key
     */
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> hashMap = new HashMap<>();
            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String key = new String(charArray);
                List<String> list = hashMap.getOrDefault(key, new ArrayList<>());
                list.add(str);
                hashMap.put(key, list);
            }
            return new ArrayList<List<String>>(hashMap.values());

        }
    }

    public static void main(String[] args) {
        Solution solution = new groupAnagrams().new Solution();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> lists = solution.groupAnagrams(strs);
        System.out.println(lists);
    }

}
