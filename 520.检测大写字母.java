/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        //先判断空字符串和长度只有1的字符串都返回true
        if(word == null || word.length() == 1) return true;
        //声明一个flag表示首字母是否为大写
        boolean flag = false;
        //记录大写字母个数
        int count = 0;
        //判断首字母形式
        if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'){
            flag = true;
            count++;
        }
        for (int i = 1; i < word.length(); i++) {
            //如果首字母大写，对后续大写字母进行计数
            if(flag){
                if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                    count++;
                }
            }
            //如果首字母不是大写，那么后续遇到大写字母直接返回false
            else{
                if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                    return false;
                }
            }
        }
        //最后遍历完成之后，分别判断首字母大写和非大写的情况
        if(flag){
            //首字母大写时，大写字母个数为1或者等于字符长度时，返回true
            if(count == 1 || count == word.length()) return true;
            else return false;
        }
        //首字母非大写时，遍历完之后直接返回true
        else return true;
    }
}
// @lc code=end

