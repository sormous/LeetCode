/*
 * @lc app=leetcode.cn id=1221 lang=java
 *
 * [1221] 分割平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        //首先判断两种特殊情况，长度为0和1时分别返回0和1
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        //res和count分别记录平衡字符串数和当前字符的计数
        int res = 0, count = 1;
        //首先记录第一个字符
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            //跟当前记录字符比较
            if(s.charAt(i) == c){
                count++;
            }
            //若不相同，则通过计数count来比较
            else{
                if(count > 0){
                    count--;
                }else{
                    c = s.charAt(i);
                    count = 1;
                }
            }
            //若当前计数等于0，则res计数++
            if(count == 0) res++;
        }
        return res;
    }
}
// @lc code=end

