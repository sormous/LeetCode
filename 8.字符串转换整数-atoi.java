/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }

        int start = 0;
        boolean positive = true;  // 记录该数为正数还是负数
        if(str.charAt(start) == ' '){
            while(str.charAt(start) == ' '){
                start++;
                if(start >= str.length()){
                    return 0;
                }
            }
        }
        if(str.charAt(start) == '-'){
            positive = false;
            start++;
        }else if(str.charAt(start) == '+'){
            start++;
        }else if(str.charAt(start) >= '0' && str.charAt(start) <= '9'){
            return cal(str, start, positive);
        }else{
            return 0;
        }

        if(start >= str.length()){
            return 0;
        }

        if(str.charAt(start) >= '0' && str.charAt(start) <= '9'){
            return cal(str, start, positive);
        }
        else{
            return 0;
        }
    }
    
    private int cal(String str, int start, boolean positive) {
       long result = 0;
       while(start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9'){
           result = result*10 + (str.charAt(start) - '0');
           start++;
           if(positive){
               if(result > Integer.MAX_VALUE){
                   return Integer.MAX_VALUE;
               }
           }
           else{
               if(-result < Integer.MIN_VALUE){
                   return Integer.MIN_VALUE;
               }
           }
       }
       if(positive){
           return (int) result;
       }else{
           return (int) -result;
       }
    }
}
// @lc code=end

