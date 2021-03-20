/*
 * @lc app=leetcode.cn id=1732 lang=java
 *
 * [1732] 找到最高海拔
 */

// @lc code=start
class Solution {
    public int largestAltitude(int[] gain) {
        //初始海拔高度
        int altitude = 0;
        //初始最高海拔
        int res = 0;
        for (int g : gain) {
            altitude = altitude + g;
            res = Math.max(res, altitude);
        }
        return res;
    }
}
// @lc code=end

