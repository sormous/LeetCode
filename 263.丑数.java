/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
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

