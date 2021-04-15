import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        char[] c = s.toCharArray();
        //用dp数组记录在i位置结尾能得到的最长有效括号
        int[] dp = new int[c.length+1];
        //首先base case，肯定为0
        dp[0] = 0;
        int res = 0, temp = 0;
        for (int i = 1; i < c.length; i++) {
            //只有当遇到右括号时，才会对最长有效括号更新
            if(c[i] == ')'){
                //temp记录的是i-1位置有效括号的之前一个字符位置
                temp = i-dp[i-1]-1;
                //如果当前temp>0，且它对应的是右括号，刚好左右括号匹配那么就可以temp的位置
                if(temp >= 0 && c[temp] == '('){
                    //若temp>0，那么除了前一位置有效括号长度+2之外，还需加上temp之前的有效括号
                    if(temp > 0){
                        dp[i] = dp[i-1] + 2 + dp[temp-1];
                    }else{
                        dp[i] = dp[i-1] + 2;
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }
}
// @lc code=end

