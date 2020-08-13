/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        //去掉字符串首尾空格字符
        s = s.trim();
        if(s.length() == 0) return 0;
        //然后以一个或多个空格字符作为间隔对字符进行切分
        String[] ans = s.split("\\s+");
        return ans.length;
    }
}
// @lc code=end

