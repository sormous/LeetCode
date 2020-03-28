import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {0, 0};
        // 记录元素出现的下标
        Map<Integer, List<Integer>> map = new HashMap<>(nums.length);
        // 将nums中的数值映射到map中，数值为key，下标为value，记录可能重复出现的元素
        for (int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        for(int num : nums){
            int gap = target - num;
            if (map.containsKey(gap)){
                if(gap == num && map.get(num).size() >= 2){
                    List<Integer> list = map.get(num);
                    result[0] = Math.min(list.get(0), list.get(1));
                    result[1] = Math.max(list.get(0), list.get(1));
                }else if(gap != num){
                    result[0] = Math.min(map.get(num).get(0), map.get(gap).get(0));
                    result[1] = Math.max(map.get(num).get(0), map.get(gap).get(0));
                }
            }
        }
        return result;
    }
}
// @lc code=end

