/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
/**
 * 从后往前遍历数组，如果遇到的数可以到达最后一个位置，则截断后面的元素。
 */
class Solution {
    public boolean canJump(int[] nums) {
        int n = 1;
        //从倒数第二个数开始遍历
        for (int i = nums.length-2; i >= 0; i--) {
            //若数值大于当前需要的步数，则截断后续，重置n为1
            if(nums[i] >= n){
                n = 1 ;
            }
            //否则n++，需要的步数+1
            else{
                n++;
            }
            //若到最后，需要的步数n>1，则无法达到
            if(i==0 && n>1){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

