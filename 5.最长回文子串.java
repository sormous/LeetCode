/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 * 找出字符串中最长的回文子串
 */

// @lc code=start
class Solution {
    /**
     * 动态规划法，
     * 假设dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串。
     * 那么可以推出：
     * dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]。
     * 这是一般的情况，由于需要依靠i+1, j -1，所以有可能 i + 1 = j -1, i +1 = (j - 1) -1，
     * 因此需要求出基准情况才能套用以上的公式：
     *
     * a. i + 1 = j -1，即回文长度为1时，dp[ i ][ i ] = true;
     * b. i +1 = (j - 1) -1，即回文长度为2时，dp[ i ][ i + 1] = (s[ i ] == s[ i + 1])。
     *
     * 有了以上分析就可以写出代码了。需要注意的是动态规划需要额外的O(n^2)的空间。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        //先判断特殊情况，空字符串或者字符串长度小于2时，直接返回
        if(s == null || s.length() < 2){
            return s;
        }

        int maxLength = 0;
        String longest = null;
        int length =s.length();
        //声明一个表，记录
        boolean[][] table = new boolean[length][length];

        //基准情况，单个字符均是回文
        for (int i=0; i<length; i++){
            table[i][i] = true;
            longest = s.substring(i, i+1);
            maxLength = 1;
        }

        //另一种基准情况，判断两个字符是否是回文
        for(int i=0; i<length-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                table[i][i+1] = true;
                longest = s.substring(i, i+2);
                maxLength = 2;
            }
        }
        
        //求长度大于2的子串是否是回文串
        for(int len=3; len<=length; len++){
            for(int i=0,j; (j=i+len-1)<=length-1; i++){
                if(s.charAt(i) == s.charAt(j)){
                    table[i][j] = table[i+1][j-1];
                    if(table[i][j] && maxLength < len){
                        longest = s.substring(i, j+1);
                        maxLength = len;
                    }
                }else{
                    table[i][j] = false;
                }
            }
        }
        return longest;
    }
}
// @lc code=end

