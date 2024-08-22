package com.yolo.leetcode._0041_group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class groupAnagrams {
    /**
     * 暴力解法，利用两遍for循环来找出所有符合的情况
     * leetcode中会导致时间超时
     */
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            boolean[] flag = new boolean[strs.length];
            List<List<String>> result = new ArrayList<List<String>>();
            for (int i = 0; i < strs.length; i++) {
                if (flag[i]) {
                    continue;
                }
                ArrayList<String> item = new ArrayList<>();
                flag[i] = true;
                item.add(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (flag[j]) {
                        continue;
                    }
                    if (isSimilarity(strs[i], strs[j])) {
                        item.add(strs[j]);
                        flag[j] = true;
                    }
                }
                result.add(item);
            }
            return result;
        }

        boolean isSimilarity(String str1, String str2) {
            byte[] str1Bytes = str1.getBytes();
            byte[] str2Bytes = str2.getBytes();
            Arrays.sort(str1Bytes);
            Arrays.sort(str2Bytes);
            if (str1Bytes.length != str2Bytes.length) {
                return false;
            }
            for (int i = 0; i < str1Bytes.length; i++) {
                if (str1Bytes[i] != str2Bytes[i]) {
                    return false;
                }
            }
            return true;


        }
    }

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {""};
//        String[] strs = {"a"};
        Solution solution = new groupAnagrams().new Solution();
        List<List<String>> lists = solution.groupAnagrams(strs);
        System.out.println(lists);


    }


}


