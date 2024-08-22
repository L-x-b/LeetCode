package com.yolo.leetcode._0041_group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class groupAnagrams_2 {
    /**
     * 通过stream流，分组排序
     * 由于每个字母异位词排序后的结果相同，所以以排序后的结果为分组依据
     */

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
                // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                char[] array = str.toCharArray();
                Arrays.sort(array);
                return new String(array);
            })).values());
        }
    }


    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {""};
//        String[] strs = {"a"};
        Solution solution = new groupAnagrams_2().new Solution();
        List<List<String>> lists = solution.groupAnagrams(strs);
        System.out.println(lists);


    }


}


