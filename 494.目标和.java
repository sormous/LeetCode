/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //如果全部和小于S，则必不可能满足
        //且因为num都为正整数，所以必须得被2整除
        if(sum < S || (sum+S) % 2 != 0) return 0;
        
        int target = (sum + S)/2;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] + dp[i-num];
            }
        }
        return dp[target];    
    }
}
// @lc code=end

