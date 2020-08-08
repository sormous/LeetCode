/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
        int carry, sum;
        sum = a^b;
        //利用异或运算获得无进位的和
        carry = (a&b) << 1;
        //利用与运算获得进位
        if(carry != 0){
            //需要将进位加上去
            return getSum(sum, carry);
        }
        return sum;
    }
}
// @lc code=end

