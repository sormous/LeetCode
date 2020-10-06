/*
 * @lc app=leetcode.cn id=1518 lang=java
 *
 * [1518] 换酒问题
 */

// @lc code=start
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while(numBottles >= numExchange){
            //加上空瓶可以兑换的瓶数
            res += numBottles/numExchange;
            //当前空瓶的数值
            numBottles = numBottles/numExchange +numBottles%numExchange;
        }
        return res;
    }
}
// @lc code=end

