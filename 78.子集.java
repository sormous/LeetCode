import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //可以直接从后遍历，
        //遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
        // List<List<Integer>> res = new ArrayList<>();
        // res.add(new ArrayList<>());
        // for(int i=0; i<nums.length; i++){
        //     int l = res.size();
        //     for(int j=0; j<l; j++){
        //         List<Integer> temp = new ArrayList<>(res.get(j));
        //         temp.add(nums[i]);
        //         res.add(temp);
        //     }
        // }
        // return res;

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, nums, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, int start, List<Integer> temp){
        if(start > nums.length) return ;
        if(!res.contains(temp)){
            //res.add(temp);
            res.add(new ArrayList<>(temp));
        }
        for(int i=start; i<nums.length; i++){
            temp.add(nums[i]);
            backtrack(res, nums, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}
// @lc code=end

