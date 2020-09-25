import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 */

// @lc code=start
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        //利用hashmap保存数组中元素值和对应的位置
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        //然后对数组进行排序
        //使用Collections.reverseOrder可以降序排列，当需要将int[]数组装换成Integer[]数组
        Arrays.sort(nums);
        //j记录分数最高的位置
        int j = nums.length-1;
        //i表示当前名次
        for (int i = 0; i < nums.length; i++) {
            if(j == nums.length-1){
                res[map.get(nums[j])] = "Gold Medal";
            }else if(j == nums.length-2){
                res[map.get(nums[j])] = "Silver Medal";
            }else if(j == nums.length-3){
                res[map.get(nums[j])] = "Bronze Medal";
            }else{
                res[map.get(nums[j])] = i+1+"";
            }
            j--;
        }
        return res;
    }
}
// @lc code=end

