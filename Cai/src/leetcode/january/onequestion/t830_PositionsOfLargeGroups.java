package leetcode.january.onequestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 较大分组的位置
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * https://leetcode-cn.com/problems/positions-of-large-groups/
 *
 * @author macfmc
 * @date 2021/1/5-22:23
 */
public class t830_PositionsOfLargeGroups {
    /**
     * 暴力法 O(n),O(1)
     *
     * @param s
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ret = new ArrayList<>();
        if (s == null) {
            return ret;
        }

        int num = 1;
        for (int i = 0; i < s.length(); i++) {
            // 判断是否可以循环且当前element和下标加一的element是否相等
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                // 大于或等于三个连续字符的分组为 较大分组
                if (num >= 3) {
                    // 按起始位置下标递增顺序排序
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                // 重新计数
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }
}
