import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1189 lang=java
 *
 * [1189] “气球” 的最大数量
 */

// @lc code=start
class Solution {
    Map<Character, Integer> window, need;

    public int maxNumberOfBalloons(String text) {
        window = new HashMap<>();
        need = new HashMap<>();
        String a = "balloon";
        for (int i = 0; i < a.length(); i++) {
            need.put(a.charAt(i), need.getOrDefault(a.charAt(i), 0)+1);
        }
        
        int count = Integer.MAX_VALUE;
        int r = 0;
        while(r < text.length()){
            char c = text.charAt(r);
            r++;
            window.put(c, window.getOrDefault(c, 0)+1);
        }
        
        for (Character c : need.keySet()) {
            count = Math.min(count, window.getOrDefault(c, 0)/need.get(c));
        }

        return count;
    }
}
// @lc code=end

