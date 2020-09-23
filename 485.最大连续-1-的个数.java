/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //利用count和max分别计数当前1的个数和最大连续1的个数
        int count = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            //等于1则count计数+1
            if(nums[i] == 1){
                count++;
            }
            //否则count置0，且当count大于max时，将count的值赋给max
            else{
                if(count > max){
                    max = count;
                }
                count = 0;
            }
        }
        //最后当结尾的数值等于1的情况需要在判断一次
        if(count > max) max = count;
        return max;
    }
}
// @lc code=end

