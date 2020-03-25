/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    /**
     * 
     * 
     * @param dividend
     * @param divisor
     * @return result
     */
    public int divide(int dividend, int divisor) {
        //相除溢出处理
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        if(divisor == 1){
            return dividend;
        }
        //记录符号位,^表示异或
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1:1;

        //记录绝对值
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        double logAns = Math.log(dvd) - Math.log(dvs);
        double result = Math.exp(logAns);  

        //int result = 0;
        //当被除数大于除数时
        //该方法为何超时？
        // while(dvd >= dvs){
        //     //记录除数
        //     long temp = dvs;
        //     //记录商的大小
        //     long mul = 1;

        //     while(dvd >= (dvs << 1)){
        //         temp <<= 1;
        //         mul <<= 1;
        //     }
        //     dvd -= temp;

        //     result += mul;
        // }
        return (int)result*sign;
    }
}
// @lc code=end

