/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
/**
 * dp[i]=dp[i-1]+(dp[i-1]-dp[i-2])*(10-(i-1));
 * 加上dp[i-1]表示，加上之前的数字
 * dp[i-1]-dp[i-2]的意思是我们上一次较上上一次多出来的各位不重复的数字。
 * 以n=3为例，n=2已经计算了0-99之间不重复的数字了，
 * 我们需要判断的是100-999之间不重复的数字，那也就只能用10-99之间的不重复的数去组成三位数，
 * 而不能使用0-9之间的不重复的数，因为他们也组成不了3位数。而10-99之间不重复的数等于dp[2]-dp[1]。
 * 当i=2时，说明之前选取的数字只有1位
 * 那么我们只要与这一位不重复即可，所以其实有9(10-1)种情况（比如1，后面可以跟0,2,3,4,5,6,7,8,9）。
 * 
 */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + (dp[i-1] - dp[i-2])*(10-(i-1));
        }
        return dp[n];
    }
}
// @lc code=end

