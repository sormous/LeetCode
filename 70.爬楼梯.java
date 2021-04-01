/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        //可以简化成只记录前两层阶梯即可，优化空间
        //int pre = 1;
        //int cur = 1;
        int[] dp = new int[n+1];
        dp[0] = 1;

        int[] steps = {1,2};
        for (int i = 0; i < dp.length; i++) {
            for (int step : steps) {
                if(i < step) continue;
                dp[i] += dp[i-step];
            }
        }


        // dp[1] = 1;
        // for (int i = 2; i < n+1; i++) {
        //     dp[i] = dp[i-2]+dp[i-1];
        // }

        return dp[n];
    }
}
// @lc code=end

