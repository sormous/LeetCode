/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        int layer = 1;
        while(n>=layer){
            n-=layer;
            layer++;
        }
        //因为上述循环中layer作为比较的基准，于最后多加了一次，输出时需要减1
        return layer-1;
    }
}
// @lc code=end

