/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        if(nums.length == 0) return res;
        int[] dp = new int[nums.length];
        //初始dp数组0位置设置为1
        dp[0] = 1;
        //重新赋值res为1，因为只要有元素存在与数组，那么就至少为1
        res = 1;
        for (int i = 1; i < nums.length; i++) {
            //若当前元素大于前一个元素，那么dp[i] = dp[i-1]+1
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1]+1;
            }else{
                //当小于时，重置dp
                dp[i] = 1;
            }
            if(dp[i] > res) res = dp[i];
        }
        return res;
    }
}
// @lc code=end

