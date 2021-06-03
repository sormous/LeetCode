import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] 连续数组
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0;
        //申明一个哈希表记录当前坐标i下，的前缀和count: map(count, i)
        Map<Integer, Integer> map = new HashMap<>();
        //首先空数组的和为0，其坐标记录为-1
        map.put(0, -1);
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == 1){
                count++;
            }else{
                count--;
            }
            //如果当前map中存在键值count，那么表示从preIndex~i的0和1个数相同
            //对res进行更新
            if(map.containsKey(count)){
                int preIndex = map.get(count);
                res = Math.max(res, i-preIndex);
            }else{
                map.put(count, i);
            }
        }
        return res;
    }
}
// @lc code=end

