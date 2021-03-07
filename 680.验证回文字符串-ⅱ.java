/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
/**
 * 简单判断回文字符串，可直接利用双指针头尾进行遍历即可
 * 本题中，可以删除一个字符，看是否还能满足回文字符串，
 * 则在前述方法的基础上，进行删除，可删除做指针的元素，也可删除右指针的元素
 * 只需进一步判断左右指针之间的子串是否为回文即可。
 */
class Solution {
    public boolean validPalindrome(String s) {
        for(int l=0, r=s.length()-1; l<r; l++, r--){
            if(s.charAt(l) != s.charAt(r)){
                //有两种删除方案，左右指针的元素
                return isPalidrome(s, l+1, r) || isPalidrome(s, l, r-1);
            }
        }
        return true;
    }

    private boolean isPalidrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

