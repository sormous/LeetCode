/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
/**
 * 可以利用一个数组来存储已经计算过的fibo数，避免重复计算导致效率低下
 * 以及可以利用动态规划的思想，初始化一个dp数组，来完成fibo数的推导
 */
class Solution {
    public int fib(int N) {
        if(N==0) return 0;
        int[] memo = new int[N+1];
        return helper(memo, N);
        /**
         * dp[1] = dp[2] = 1
         * i >= 3: dp[i] = dp[i-1] + dp[i-2]
         */
    }

    private int helper(int[] memo, int N){
        if(N==1 || N==2){
            return 1;
        }
        if(memo[N] != 0) return memo[N];
        memo[N] = helper(memo, N-1) + helper(memo, N-2);
        return memo[N];
    }
}
// @lc code=end

