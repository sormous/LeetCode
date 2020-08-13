/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        //carry记录是否有进位
        int carry = 0, i=num1.length()-1, j=num2.length()-1;
        //数组未越界，或者有进位时进行运算
        while(i>=0 || j>=0 || carry != 0){
            if(i >= 0) carry += num1.charAt(i--)-'0';
            if(j >= 0) carry += num2.charAt(j--)-'0';
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }   
}
// @lc code=end

