import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    Map<Character, Integer> window = new HashMap<>();

    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0;
        int res = 0;
        while(r < s.length()){
            char c = s.charAt(r);
            r++;
            window.put(c, window.getOrDefault(c, 0)+1);

            //当前window中有重复值了，那么就收缩窗口，知道没有重复值
            while(window.get(c) > 1){
                char d = s.charAt(l);
                l++;
                window.put(d, window.getOrDefault(d, 0)-1);
            }
            res = Math.max(res, r-l);
        }
        return res;
    }
}
// @lc code=end

