import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //首先得排序
        Arrays.sort(nums);
        getAns(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> res){
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            //和上个数相等就跳过
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            getAns(nums, i+1, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}
// @lc code=end

