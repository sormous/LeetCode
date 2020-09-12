/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        //首先判空，当num中字符为空时返回空字符串
        if(num1.length() == 0 || num2.length() == 0) return null;
        if(num1 == null || num2 == null) return null;
        int n1 = num1.length()-1, n2 = num2.length()-1;
        //记录乘积的每一位的数组
        int[] mul = new int[n1+n2+2];
        for (int i = n1; i >= 0; --i) {
            for (int j = n2; j >= 0; --j) {
                int bit = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                //先加低位判断是否有进位
                bit += mul[i+j+1];
                //高位为当前值加上对10求除
                mul[i+j] += bit/10;
                //低位变成乘积对10求余
                mul[i+j+1] = bit%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        //将前导0去掉
        while(i<mul.length-1 && mul[i] == 0) i++;
        for(; i<mul.length; i++){
            sb.append(mul[i]);
        }
        return sb.toString();
    }
}
// @lc code=end

