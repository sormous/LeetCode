/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    /**
     * 找出一个字符串数组中的最长公共前缀
     * 
     * 从长度最小的字符串开始，然后以这个字符串为基准，找出最短的公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        //首先判断特殊情况
        //首先判断字符串是否为空
        if (strs == null){
            return null;
        }
        
        //字符串数组存在，但长度为0，直接返回“”字符
        if(strs.length == 0){
            return "";
        }
        
        //记录最短的字符串长度
        int min = Integer.MAX_VALUE;

        String result = "";
        //长出最短字符串
        for(String str : strs){
            //若数组中存在空字符串直接返回“”
            if(str == null || str.length() == 0){
                return "";
            }

            if(min > str.length()){
                min = str.length();
                result = str;
            }
        }

        for (String s: strs){
            for(int i=0; i<result.length(); i++){
                if(result.charAt(i) != s.charAt(i)){
                    result = result.substring(0, i);
                    //若i大于字符串长度会抛出异常不影响结果
                }
            }
        }
        /**
         * 或者另一种方法，利用一个值来记录最长前缀的字符数长度
         * 设置一个flag来标记是否还相同
         */
        return result;
    }
}
// @lc code=end

