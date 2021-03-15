import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1647 lang=java
 *
 * [1647] 字符频次唯一的最小删除次数
 */

// @lc code=start
class Solution {
    public int minDeletions(String s) {
        int res = 0;
        int[] map = new int[26];
        char[] letters = s.toCharArray();
        for (char c : letters) {    //统计字母出现的次数
            map[c-'a']++;
        }

        Set<Integer> set = new HashSet<>();
        for (int times : map) {
            if(times != 0){     //当字母存在时，才进行判断和添加
                while(set.contains(times)){     //set中已经存在该次数时，则自减，直到次数唯一
                    times--;
                    res++;
                }
                if(times != 0){     //若删除之后，仍有，则添加进set中
                    set.add(times);
                }
            }
        }
        return res;
    }
}
// @lc code=end

