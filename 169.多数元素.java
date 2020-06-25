/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
/**
 * 从数组中第一个数开始，以其为基础开始计数，
 * 遇到相同的就计数加1，不同的则减1，
 * 若计数减到0，则换成当前数值为准开始比较，
 * 遍历整个数组，留在最后的即为多数元素。
 */
class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int num : nums) {
            if(num != res){
                count--;
                if(count == 0){
                    count = 1;
                    res = num;
                }
            }
            else{
                count++;
            }
        }
        return res;
    }
}
// @lc code=end

