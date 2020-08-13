/*
 * @lc app=leetcode.cn id=405 lang=java
 *
 * [405] 数字转换为十六进制数
 */

// @lc code=start
/**
 * 使用0xf(00...01111b)获取num的低4位。
>>算数位移，其中正数右移左边补0，负数右移左边补1。
位移运算并不能保证num==0，需要使用32位int保证（对应16进制小于等于8位）。
 */
class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";
        char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder sb = new StringBuilder();
        while(num != 0 && sb.length() < 8){
            sb.append(chars[num & 0xf]);
            num >>= 4;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

