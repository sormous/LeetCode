/*
 * @lc app=leetcode.cn id=914 lang=java
 *
 * [914] 卡牌分组
 */

// @lc code=start
/**
 * 因为若x存在，那么一定是次数的约数，
 * 那么对于全数组，则是整个数组每个数字的公约数，才可能存在分组
 */
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int d : deck) {
            count[d]++;
        }

        int g = -1;
        for (int c : count) {
            if(c > 0){
                if(g == -1){
                    g = c;
                }else{
                    g = gcd(g, c);
                }
            }
        }
        return g >= 2;
    }

    private int gcd(int x, int y){
        return x == 0? y:gcd(y%x, x);
    }
}
// @lc code=end

