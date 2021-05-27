/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
/**
 * 首先对两数进行异或运算，求出不相同的位，
 * 然后对异或值的每一位和1做与运算，即可求得不相同的位数和
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        return  Integer.bitCount(z);

        // int sum = 0;
        // while(z != 0){
        //     sum += z&1;
        //     z = z>>1;
        // }
        // return sum;
    }
}
// @lc code=end

