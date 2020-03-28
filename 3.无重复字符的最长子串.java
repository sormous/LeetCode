import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        int start = 0;
        int result = 0;
        // 哈希表记录字符串中每一个字符和它的位置
        Map<Character, Integer> map = new HashMap<>(s.length());
        
        //遍历字符串，遇到与子串中字符重复的字符则将子串起始位置+1
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch) && map.get(ch) >= start){
                start = map.get(ch) + 1;
            }
            else{
                result = Math.max(result, i-start+1);
            }
            map.put(ch, i);
        }
        return result;
    }
}
// @lc code=end

