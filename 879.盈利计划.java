/*
 * @lc app=leetcode.cn id=879 lang=java
 *
 * [879] 盈利计划
 */

// @lc code=start
class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        int MOD = (int)1e9+7; 
        //申明一个dp数组。用来记录当前已选择的工作(m)，选择的人数(n)，以及当前最少获得的利润
        int[][][] dp = new int[m+1][n+1][minProfit+1];
        dp[0][0][0] = 1;

        for (int i = 1; i <= m; i++) {
            int p_need = group[i-1], gain = profit[i-1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    //如果当前人数不够，那么该项工作必不能选择
                    if(j < p_need){
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                    //人数足够，那么当前情况就可以变成选择开展当前工作，以及不开展当前工作之和
                    else{
                        dp[i][j][k] = (dp[i-1][j][k] + dp[i-1][j-p_need][Math.max(0, k-gain)])%MOD;
                    }
                }
            }
        }

        int res = 0;
        for (int j = 0; j <= n; j++) {
            res = (res + dp[m][j][minProfit]) % MOD;
        }
        return res;
    }
}
// @lc code=end

