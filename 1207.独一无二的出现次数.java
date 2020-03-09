import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1207 lang=java
 *
 * [1207] 独一无二的出现次数
 */

// @lc code=start
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int elem : arr){
            counter.put(elem, counter.getOrDefault(elem, 0) + 1);
        }

        return counter.size() == new HashSet<Integer>(counter.values()).size();

    }
}
// @lc code=end

