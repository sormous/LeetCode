/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        while(n>1 && n%2==0){
            n/=2;
        }
        if(n==1){
            return true;
        }
        else{
            return false;
        }
    }
}
// @lc code=end

