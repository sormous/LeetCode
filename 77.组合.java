import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            l.add(i);
        }
        backtrack(0, k, l, new ArrayList<>());
        return res;
    }

    private void backtrack(int s, int k, List<Integer> l, List<Integer> temp){
        //当长度等于k时，则添加列表
        if(temp.size() == k){
            res.add(temp);
            return ;
        }
        for (int i = s; i < l.size(); i++) {
            temp.add(l.get(i));
            //需要额外声明一个列表，存储需要的添加列表元素
            List<Integer> c = new ArrayList<>(temp);
            backtrack(i+1, k, l, c);
            //回溯之后需要删除前面递归添加的最后一个元素
            temp.remove(temp.size()-1);
        }
    }
}
// @lc code=end

