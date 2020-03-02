
/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int l = s.length() - 1;
        int ans=0;
        while(l >= 0 && s.charAt(l) == ' '){
            l--;
        }
        if(l < 0){
            return 0;
        }
        int temp = l;
        while(l >= 0 && s.charAt(l) != ' '){
            l--;
        }
        ans = temp - l;
        return ans;
    }
}
// @lc code=end

