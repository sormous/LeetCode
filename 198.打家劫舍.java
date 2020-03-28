/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    /**
     * 动态规划题
     * 
     */
    public int rob(int[] nums) {
        //判空
        if(nums.length == 0){
            return 0;
        }
        //新建一个数组记录每个位置上可取得的最大值
        int[] temp = new int[nums.length];
        //用来记录当前可以获取的最大值
        int result = 0;

        for(int i = 0; i<nums.length; i++){
            //第1，2个为特殊情况，单独记录
            if(i==0){
                temp[i] = nums[i];
            }
            else if(i==1){
                temp[i] = (nums[i] > temp[i-1]) ? nums[i] : temp[i-1];
            }
            
            else if(i > 1){
                temp[i] = ((nums[i]+temp[i-2]) > temp[i-1]) ? nums[i]+temp[i-2] : temp[i-1];
            }
            if(temp[i] > result){
                result = temp[i];
            }
        }
        return result;
    }
}
// @lc code=end

