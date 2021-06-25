import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    //完全背包解决方案
    public int numSquares(int n) {
        //申明一个dp数组来记录当前数字最少需要的完全平方数
        int[] dp = new int[n+1];
        //最初填充MaxValue
        Arrays.fill(dp, Integer.MAX_VALUE);
        //0位置为0，方便后续计算
        dp[0] = 0;
        
        int max_square_index = (int)Math.sqrt(n)+1;
        int[] square_nums = new int[max_square_index];
        for (int i = 0; i < max_square_index; i++) {
            square_nums[i] = i*i;
        }

        //从1开始计算并存储
        for (int i = 1; i <= n; i++) {
            //遍历小于i的完全平方数，dp[i]等于其中最小的+1
            for (int j = 1; j < max_square_index; j++) {
                if(i < square_nums[j]) break;
                dp[i] = Math.min(dp[i], dp[i-square_nums[j]]+1);
            }
        }
        return dp[n];
    }

    //贪心方法, 可以首先判断是否是1个数的平方数，接着是否是2个...
    // nums = set([i*i for i in range(1, sqrt(n)+1)])
    //(n, count)， count从1开始遍历，判断当前是否为平方数
    
}
// @lc code=end

