
/*
 * @lc app=leetcode.cn id=1365 lang=java
 *
 * [1365] 有多少小于当前数字的数字
 */

// @lc code=start
/**
 * 两层遍历数组，与当前数字进行比较
 * 比当前数字小，则计数+1
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            int count = 0;
            for (int num : nums) {
                if(num < nums[i]){
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
// @lc code=end

