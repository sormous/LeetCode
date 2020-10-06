import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=561 lang=java
 *
 * [561] 数组拆分 I
 */

// @lc code=start
/**
 * 先将数组排序，最大和即为奇数位数字和
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            ans+=nums[i];
        }
        return ans;
    }
}
// @lc code=end

