/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
/**
 * 首先利用数组或者hashmap记录每个字符出现的次数
 * 出现大于2次的字符即可添加到回文串中，count/2*2即为添加进回文串的长度
 * 只出现一次的字符，则只能放在在回文串中央，只能有一个字符添加
 */
class Solution {
    public int longestPalindrome(String s) {
        int[] chars = new int[128];
        int ans = 0;
        for(char c:s.toCharArray()){
            chars[c]++;
        }
        for (int count : chars) {
            ans += count/2*2;
            //利用以下判断，可以很方便的添加中央字符，后续则不会再需要
            if(count%2 == 1 && ans%2 == 0){
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

