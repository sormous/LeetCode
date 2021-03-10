import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
/**
 * DFS问题类型，该题需要额外判断是否有重复的数组选取
 * 所以我们在交换元素值进行DFS之前进行一个判断是否需要交换的操作
 * 因为DFS是在每一轮从[level, length-1]中顺序选取下一个元素，若准备交换的元素nums[cur],
 * 而在[level, cur-1]中有相同元素值，则说明该数字已经被选取过了，再选择后面就会重复
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        //方法1
        // dfs(nums, 0);
        // return res;

        //方法2
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(temp, res, nums, visited);
        return res;
    }

    private void backtrack(List<Integer> temp, List<List<Integer>> res, int[] nums, boolean[] visited){
        if(temp.size() == nums.length){
            res.add(new ArrayList<Integer>(temp));
            return ;
        }
        
        for (int i = 0; i < nums.length; i++) {
            //在数组排序之后，添加该元素前，先判断元素是否等于前一个元素，若等于且前一个元素还未访问，则直接跳过该元素
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;   //避免重复的方法
            }
            if(visited[i]) continue;
            temp.add(nums[i]);
            visited[i] = true;
            backtrack(temp, res, nums, visited);
            visited[i] = false;
            temp.remove(temp.size()-1);

        }
    }


    private void dfs(int[] nums, int cur){
        //当cur==length，则添加进结果数组
        if(cur == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num:nums){
                temp.add(num);
            }
            res.add(temp);
        }else{
            for (int i = cur; i < nums.length; i++) {
                if(canSwap(nums, cur, i)){
                    swap(nums, cur, i);
                    dfs(nums, cur+1);
                    //交换回去
                    swap(nums, cur, i);
                }
            }
        }
    }
    //判断nums[begin, end-1]是否有与nums[end]相同的数值，避免重复情况
    private boolean canSwap(int[] nums, int begin, int end){
        for (int i = begin; i < end; i++) {
            if(nums[i] == nums[end]){
                return false;
            }
        }
        return true;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

