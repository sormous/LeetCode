/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    int[] dp;
    public int jump(int[] nums) {
        int n = nums.length;
        //申明一个dp数组，用来记录当前位置达到终点最少需要的跳跃次数
        dp = new int[n];
        //base case，最终位置为0
        dp[n-1] = 0;
        for (int i = n-2; i >= 0; i--) {
            //当当前位置可跳跃步数大于等于到达终点需要的步数，则dp[i]=1
            if(nums[i] >= n-1-i){
                dp[i] = 1;
            }else{
                int minStep = findMin(dp, i, nums[i]);
                dp[i] = minStep == Integer.MAX_VALUE ? minStep:minStep+1;
            }
        }
        return dp[0];
    }

    //利用该函数找出当前位置可行步数范围内，找到后续位置到达终点的最小值
    private int findMin(int[] dp, int i, int step){
        int minStep = Integer.MAX_VALUE;
        for (int j = i+1; j <= dp.length-1 && j<=i+step; j++) {
            minStep = Math.min(minStep, dp[j]);
        }
        return minStep;
    }
}
// @lc code=end

