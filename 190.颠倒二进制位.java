/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int a = 0;
        for (int i = 0; i <= 31; i++) {
            a = a+((1&(n>>i))<<(31-i));
        }
        return a;
    }
}
// @lc code=end

