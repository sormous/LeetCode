/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[target];
    }
}
// @lc code=end

