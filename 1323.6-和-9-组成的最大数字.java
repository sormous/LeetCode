/*
 * @lc app=leetcode.cn id=1323 lang=java
 *
 * [1323] 6 和 9 组成的最大数字
 */

// @lc code=start
class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        //将字符中的第一个6变成9，即可转变成最大的数
        s = s.replaceFirst("6", "9");
        return Integer.valueOf(s).intValue();
    }
}
// @lc code=end

