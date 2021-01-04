/*
* 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*使用滑动窗口法*/
        int start = 0;
        int end = 0;
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        /*哈希表用于存储下一个头指针的位置*/
        for(;end < s.length();end++){
            if(map.containsKey(s.charAt(end)))/*如果出现重复字母则更新首指针到尾指针的下一个*/
                start = Math.max(start,map.get(s.charAt(end)));
            res = Math.max(res,end - start + 1);
            map.put(s.charAt(end),end + 1);
        }
        return res;

    }
}