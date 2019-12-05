/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        long tmp = x;
        long result = 0;
        while(tmp != 0){
            result = result*10 + tmp%10;
            tmp /= 10;
        }
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE){
            result = 0;
        }
        return (int) result;
    }
}
// @lc code=end

