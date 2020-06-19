/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 */

// @lc code=start

/**
 * 将所给字符串转换成字符数组，然后求字符数组的int和，做差，转回char，返回即所答案
 */
class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0; //记录字符串的值
        char[] a = s.toCharArray(); //将对应的字符串转换成字符数组
        for (int i = 0; i < a.length; i++) {
            sum -= (int)a[i];
        }
        char[] b = t.toCharArray();
        for (int i = 0; i < b.length; i++) {
            sum += (int)b[i];
        }
        return (char)sum;
    }
}
// @lc code=end

