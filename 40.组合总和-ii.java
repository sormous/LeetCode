import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        find(res, temp, candidates, target, 0);
        return res;
    }
    
    //对排序好的数组进行遍历判断
    private void find(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int index){
        if(target == 0){
            res.add(temp);
            return ;
        }
        if(target < candidates[0]) return ;
        //从index开始作为起始指针，且当前元素值<target
        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            //对于排序好的数组，以下可有效避免重复组合
            if(i > index && candidates[i] == candidates[i-1]) continue;
            //复制一份temp列表，从而不影响下一次递归
            List<Integer> list = new ArrayList<>(temp);
            list.add(candidates[i]);
            //使用index=i+1，不重复使用元素值
            find(res, list, candidates, target-candidates[i], i+1);
        }
    }
}
// @lc code=end

