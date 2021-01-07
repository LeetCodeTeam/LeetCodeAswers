package leetcode.algorithm;

import java.util.HashMap;

/**
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入：s ="abcabcbb"
 * 输出：3
 * 解释："abc" 是一个abcabcbb中的无重复最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author JiangZhuoan
 * @date 2021/1/7-18:56
 */

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口的头指针
        int start = 0;
        //滑动窗口的头指针
        int end = 0;
        int res = 0;
        //哈希表用于存储尾指针的下一个字母的指针
        HashMap<Character,Integer> map = new HashMap<>();
        for(;end < s.length();end++){
            //判断是否存在重复的字母
            if(map.containsKey(s.charAt(end))) {
                //如果是则更新头指针
                start = Math.max(start, map.get(s.charAt(end)));
            }
            //更新结果
            res = Math.max(res,end - start + 1);
            //将尾指针下一位push进哈希表
            map.put(s.charAt(end),end + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = new String();
        str = "abcabcbb";
        LeetCode3 leetCode3 = new LeetCode3();
        int i = leetCode3.lengthOfLongestSubstring(str);
        System.out.println(i);
    }
}
