/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 */

// @lc code=start
/**
 * 与判断3的幂同理，当num>1且对4求余时，对num取除以4的值，
 * 循环判断，直至num不满足条件，判断最后的num是否等于1，是则为true，否则为false.
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num&(0xaaaaaaaa)) == 0;
        // while(num > 1 && num%4 == 0){
        //     num /= 4;
        // }
        // if(num == 1) return true;
        // else return false;
    }
}
// @lc code=end

