/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int max1 = Integer.MIN_VALUE; //记录数组中的最大值
        int max2 = Integer.MIN_VALUE; //记录数组中的第二大值
        int max3 = Integer.MIN_VALUE; //记录数组中的第三大值
        boolean f = true; //最为一个标记，表示数组中是否出现了Integer.MIN_VALUE
        int var = 0; //记录数组中数值的个数
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == Integer.MIN_VALUE && f){
                var++;
                f = false;
            }
            if(nums[i] > max1){
                var++;
                max3 = max2; //第二大的值变为第三大
                max2 = max1; //最大的值变为第二大，该顺序不能变，否则赋值出错
                max1 = nums[i]; 
            }else if(nums[i] < max1 && nums[i] > max2){
                var++;
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i] < max2 && nums[i] > max3){
                var++;
                max3 = nums[i];
            }
        }
        return var>=3 ? max3:max1;
    }
}
// @lc code=end

