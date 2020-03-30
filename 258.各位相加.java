/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        int a, b;
        while(num>=10){
            a = num%10;
            b = num/10;
            num = a+b;
        }
        return num;
    }
}
// @lc code=end

