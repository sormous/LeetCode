import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
/**
 * 也可以理解成一个DFS问题
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generate(res, "", 0, 0, n);
        return res;
    }
    //分别利用l,r来记录左括号和右括号的个数
    private void generate(List<String> res, String str, int l, int r, int n){
        //当左括号或右括号个数大于阈值时，则该次递归结束
        if(l > n || r > n) return;
        //当左右括号都等于n时，则添加进返回列表中
        if(l==n && r==n) res.add(str);
        //作为左右括号的添加的前置条件，左括号数要大于等于右括号数
        if(l >= r){
            generate(res, str+"(", l+1, r, n);
            generate(res, str+")", l, r+1, n);
        }
    }
}
// @lc code=end

