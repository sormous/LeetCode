import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=456 lang=java
 *
 * [456] 132模式
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
            for (int j = i+1; j < nums.length; j++) {
                
            }
        }
    }
}
// @lc code=end

