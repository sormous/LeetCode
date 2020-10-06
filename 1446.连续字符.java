/*
 * @lc app=leetcode.cn id=1446 lang=java
 *
 * [1446] 连续字符
 */

// @lc code=start
class Solution {
    public int maxPower(String s) {
        //count，res分别记录当前字符数和最大连续字符数
        int count = 0, res = 0;
        //c记录当前字符
        char c = ' ';
        for (int i = 0; i < s.length(); i++) {
            //若相同字符则计数+1
            if(s.charAt(i) == c){
                count++;
            }
            //否则改变比较字符和计数值
            else{
                count = 1;
                c = s.charAt(i);
            }
            if(count > res){
                res = count;
            }
        }
        return res;
    }
}
// @lc code=end

