import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else{
                map.put(num, map.get(num)+1);
            }
        }

        for(int key : map.keySet()){
            if(map.get(key) == 1){
                result = key;
                break;
            }
        }
        return result;
    }
}
// @lc code=end

