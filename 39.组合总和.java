import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        //排序
        Arrays.sort(candidates);
        find(listAll, list, candidates, target, 0);
        return listAll;


    }

    public void find(List<List<Integer>> listAll, List<Integer> temp, int[] candidates, int target, int num){
        if(target == 0){
            listAll.add(temp);
            return ;
        }
        if(target < candidates[0]) return;
        for(int i=num; i<candidates.length && candidates[i] <= target; i++){
            //拷贝一份，不影响下次递归
            List<Integer> list = new ArrayList<>(temp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll, list, candidates, target-candidates[i], i);
        }        
    }
}
// @lc code=end

