/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3的幂
 */

// @lc code=start
/**
 * 用n对3求余，若余数为0，则将n赋值为除以3的结果，继续判断，直到求余不为0或者小于等于1；
 * 进行下一步判断n是否等于1，若是则为3的幂，否则不是。
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        while(n > 1 & n%3 == 0){
            n /= 3;
        }
        if(n==1){
            return true;
        }
        else return false;
    }
}
// @lc code=end

