/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    //     int count = 0;
    //     while(n != 0){
    //         count++;
    //         n = (n - 1 ) & n;
    //重复操作，有多少个1，这个操作就可以执行多少次。
    //     }
    //     return count;
        return Integer.bitCount(n);
     }

}
// @lc code=end

