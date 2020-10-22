import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start
/**
 * 将糖果按种类存储进hashmap中，然后对map的size进行操作比较
 */
class Solution {
    public int distributeCandies(int[] candies) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int candy : candies) {
            map.put(candy, map.getOrDefault(candy, 0)+1);
        }
        //比价map的size与糖果数量二分之一的大小
        //如果糖果种类即map.szie小于等于糖果数量的二分之一，直接返回糖果种类数
        if(map.size() <= candies.length/2) return map.size();
        //如果大于，则返回糖果种类的二分之一即可
        else return candies.length/2; 
    }
}
// @lc code=end

