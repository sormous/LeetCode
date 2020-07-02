/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
/**
 * 统计每个字符串中连续相同数字的个数
 */
class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i=2; i<=n; i++){
            s = convert(s);
        }
        return s;
    }

    private String convert(String s){
        int len = s.length();
        int n=0; //用来计数连续相同数字的个数
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0); //首先以第一个字符为比较基础
        int i = 0; 
        while(i<len){
            if(c == s.charAt(i)){
                i++;
                n++;
            }else{
                //当遇到不同字符时，添加记录当前有n个c字符
                sb.append(n).append(c); 
                n = 1; //然后重置计数为1
                c = s.charAt(i); //字符c变成新字符
                i++;
            }
        }
        sb.append(n).append(c); //最后一个连续字符需要单独添加进字符串
        return sb.toString();
    }
}
// @lc code=end

