import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    /**
     * 异或具有交换律 a^b^c = a^c^b
     * 任何数与0异或为其本身 0^n = n
     * 
     * 
     * @param nums
     * @return result
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums){
            result = result ^ num;
        }
        return result;

        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int num : nums){
        //     if(!map.containsKey(num)){
        //         map.put(num, 1);
        //     }
        //     else{
        //         map.remove(num);
        //     }
        // }

        // for(int key : map.keySet()){
        //     result = key;
        // }
        // return result;
    }
}
// @lc code=end

