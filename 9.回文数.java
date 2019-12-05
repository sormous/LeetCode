/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        long reverse = 0;
        int temp = x;
        while(temp > 0){
            reverse = reverse*10 + temp%10;
            temp = temp/10;
        }

        return reverse == x;
        
        // int a, b;
        // String s = Integer.toString(x);
        // a = 0;
        // b = s.length()-1;
        // while(a < b){
        //     if(s.charAt(a) != s.charAt(b)){
        //         return false;
        //     }
        // }
        // return true;
    }
}
// @lc code=end

