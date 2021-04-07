/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }
        int res = 1;
        //申明3个变量，分别表示当前位置，重复值的个数，和重复值
        int cur = 1, count = 1, temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == temp){
                count++;
            }else{
                temp = nums[i];
                count = 1;
            }
            if(count > 2){
                continue;
            }
            nums[cur] = nums[i];
            cur++;
            res++;
        }
        return res;
    }
}
// @lc code=end

