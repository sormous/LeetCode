import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //利用visited数组记录已经选择的元素
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<>(), visited);
        return res;
    }

    //回溯算法
    public void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> temp, int[] visited){
        //当长度达到指定长度后，添加数组，并停止递归
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            temp.add(nums[i]);
            backtrack(res, nums, temp, visited);
            //到下一次遍历循环时，重置当前元素的visited值
            visited[i] = 0;
            //然后删去添加进行的元素值
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

