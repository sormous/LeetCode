import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == temp){
                return temp;
            }
            temp = nums[i];
        }
        return temp;
    }
}
// @lc code=end

