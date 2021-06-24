/*
 * @lc app=leetcode.cn id=664 lang=java
 *
 * [664] 奇怪的打印机
 */

// @lc code=start
class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        //申明一个二维数组dp[i][j]，记录从i~j位置所需要的最小次数
        int[][] dp = new int[n][n];

        //保证无后效性，i应该从大到小枚举，j应该从小到大枚举
        for (int i = n-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i][j-1];
                }else{
                    int temp = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        temp = Math.min(temp, dp[i][k] + dp[k+1][j]);
                    }
                    dp[i][j] = temp;
                }
            }
        }
        return dp[0][n-1];
    }
}
// @lc code=end

