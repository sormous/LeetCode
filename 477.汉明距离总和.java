/*
 * @lc app=leetcode.cn id=477 lang=java
 *
 * [477] 汉明距离总和
 */

// @lc code=start
class Solution {
    public int totalHammingDistance(int[] nums) {
        //记录每一位上，1的个数，做乘积求和即可
        int res = 0, n = nums.length;
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int num : nums) {
                c += (num >> i) & 1;
            }
            res += c*(n-c);
        }
        return res;


        // 暴力解法，勉强能过
        // int res = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i+1; j < nums.length; j++) {
        //         int temp = nums[i]^nums[j];
        //         res += Integer.bitCount(temp);
        //     }
        // }
        // return res;
    }
}
// @lc code=end

