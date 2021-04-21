/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    /**
     * 利用动态规划，可选一个或者两个字符进行解码
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            // 选择一个字符进行解码
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            //选择该字符和前一个字符，两个字符进行解码
            if(i > 1 && s.charAt(i-2) != '0' && (s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0') <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
        
    }
}
// @lc code=end

