import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        int res = Integer.MAX_VALUE;
        //申明一个列表，保存数组中出现次数最多的数
        List<Integer> l = new ArrayList<>();
        //申明一个map保存每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        //找到出现次数为度的数字
        for (int key : map.keySet()) {
            if(map.get(key) > max){
                max = map.get(key);
                l.clear();
                l.add(key);
            }else if(map.get(key) == max){
                l.add(key);
            }
        }

        //然后利用双指针求得拥有相同度的最短连续子数组
        int temp = 0;
        for (int a : l) {
            int i=0, j=nums.length-1;
            while(nums[i] != a){
                i++;
            }
            while(nums[j] != a){
                j--;
            }
            temp = j-i+1;
            res = Math.min(temp, res);
        }
        return res;
    }
}
// @lc code=end

