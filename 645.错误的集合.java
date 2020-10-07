import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        //利用hashmap存储整数及次数
        Map<Integer, Integer> map = new HashMap<>();
        //分别表示重复数字和丢失数字
        int dup = -1, missing = -1;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if(map.containsKey(i)){
                //如果map中包含该数，且出现次数为2次，则找到重复的数字
                if(map.get(i) == 2){
                    dup = i;
                }
            }
            //若map中没找到该数，则找到丢失数字
            else{
                missing = i;
            }
        }
        return new int[]{dup, missing};
    }
}
// @lc code=end

