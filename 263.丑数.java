/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
/**
 * 判断丑数，从最大质数5开始，while循环判断当前num是否大于1且对5求余是否为0，并对num赋值为/=5；
 * 跳出循环后，依质数大小顺序接着判断，依次判断3和2，
 * 直至最后,若num等于1则返回true，否则false
 */
class Solution {
    public boolean isUgly(int num) {
        while(num > 1 && num % 5 == 0){
            num/=5;
        }
        while(num > 1 && num % 3 == 0){
            num/=3;
        }
        while(num > 1 && num % 2 == 0){
            num/=2;
        }
        if(num == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
// @lc code=end

