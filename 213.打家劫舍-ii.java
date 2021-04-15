/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        //返回[0, n-2]和[1,n-1]范围的最大结果
        //分别表示不偷最后一间房和不偷第一间房
        return Math.max(MyRob(nums, 0, n-2), MyRob(nums, 1, n-1));
    }

    private int MyRob(int[] nums, int start, int end){
        int first = nums[start];
        int second = Math.max(nums[start], nums[start+1]);

        for (int i = start+2; i <= end; i++) {
            int temp = second;
            second = Math.max(first+nums[i], second);
            first = temp;
        }
        return second;
    }
}
// @lc code=end

