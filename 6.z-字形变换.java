/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() <= numRows || numRows == 1){
            return s;
        }
        
        int index = s.length();
        int rowLength = 0;
        int slash = numRows - 2;

        while(index > 0){
            index -= numRows;
            rowLength++;

            for(int i=0; i<slash && index>0; i++){
                rowLength++;
                index--;
            }
        }
        char[] result = new char[numRows*rowLength];
        for(int i=0; i<result.length; i++){
            result[i] = ' ';
        }
        int curColumn = 0;
        index = 0;
        while(index < s.length()){
           for(int i=0; i<numRows && index<s.length(); i++){
               result[rowLength*i + curColumn] = s.charAt(index);
               index++;
           }
           curColumn++;
           for(int i=numRows-2; i>0 && index<s.length(); i--){
               result[rowLength*i + curColumn] = s.charAt(index);
               curColumn++;
               index++;
           }
        }
        index = 0;
        while(index<s.length() && result[index] != ' '){
            index++;
        }
        int next = index+1;
        while(index < s.length()){
            while(next < result.length && result[next] == ' '){
                next++;
            }
            result[index] = result[next];
            index++;
            next++;
        }
        return new String(result, 0, index);
    }
}
// @lc code=end

