/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        //声明一个String Buffer来存储求和之后的字符串
        StringBuffer sb = new StringBuffer();
        //从字符串末尾开始计算
        int i = a.length()-1;
        int j = b.length()-1;
        while(i>=0 || j>=0 || carry != 0){
            //以carry变量来记录当前位数的和值
            if(i >= 0) carry += a.charAt(i) - '0';
            if(j >= 0) carry += b.charAt(j) - '0';
            sb.append(carry%2);
            carry/=2;
            i--;
            j--;
        }
        //最后返回存储的和值反转并且转成字符串格式
        return sb.reverse().toString();

    }
}
// @lc code=end

