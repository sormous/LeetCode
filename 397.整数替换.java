/*
 * @lc app=leetcode.cn id=397 lang=java
 *
 * [397] 整数替换
 */

// @lc code=start
//需要将n设为long型，否则当n等于2^31-1时可能越界
class Solution {
    public int integerReplacement(long n) {
        //首先判断递归结束条件，当n==1时结束递归
        if(n == 1) return 0;

        //若当前n为奇数，则递归对当前数字的+1或者-1进行计算判断
        if((n&1) == 1){
            return 1+Math.min(integerReplacement(n-1), integerReplacement(n+1));
        }
        //若当前n为偶数，则对当前数字右移一位
        else{
            return 1+integerReplacement(n>>1);
        }
    }
}
// @lc code=end

