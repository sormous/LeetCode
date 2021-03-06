/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
/**
 * 通过双指针，分别指向两个数组的头部
 * 进行遍历字符判断是否相等，最后判断长度是否和子字符串相等？
 */
class Solution {
    public boolean isSubsequence(String s, String t){
        int i=0, j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s.length();
    }
    // public boolean isSubsequence(String s, String t) {
    //     if(s.length() == 0) return true;
    //     if(t.length() == 0) return false;
    //     for (int i = 0; i < t.length(); ) {
    //         for (int j = 0; j < s.length() ; j++) {
    //             while(s.charAt(j) != t.charAt(i)){
    //                 i++;
    //                 if(i>t.length()-1){
    //                     return false;
    //                 }
    //             }
    //             if(j == s.length()-1) break;
    //             i++;
    //             if(i>t.length()-1){
    //                 return false;
    //             }
    //         }
    //         break;
    //     }
    //     return true;
    // }
}
// @lc code=end

