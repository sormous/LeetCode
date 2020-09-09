import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    private List<String> res = new ArrayList<>();
    //声明一个字符数组，分别对应键盘上0-9的字符
    private String[] letterMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        //首先判空
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        //利用dfs遍历即可
        traceBack("", digits, 0);
        return res;
    }

    //dfs遍历方法，temp记录当前已选取的字符，index表示第几个，最大到digits.length()
    private void traceBack(String temp, String digits, int index){
        if(index == digits.length()){
            res.add(temp);
            return;
        }
        for(Character c : letterMap[Integer.valueOf(digits.substring(index, index+1))].toCharArray()){
            traceBack(temp+c, digits, index+1);
        }
    }
}
// @lc code=end

