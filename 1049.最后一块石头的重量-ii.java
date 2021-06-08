import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int m = sum/2;
        //申明一个dp数组，来记录能否通过当前石头达到m重量
        boolean[] dp = new boolean[m+1];
        //达到0重量初始为true
        dp[0] = true;
        for (int stone : stones) {
            //倒序进行遍历，否则dp[i-stone]提前被覆盖，为下一组的
            for (int i = m; i >= stone; i--) {
                dp[i] = dp[i] || dp[i-stone];
            }
        }

        for (int i = m;; i--) {
            if(dp[i]){
                return sum-2*i;
            }
        }
    }
}
// @lc code=end

