/*
 * @lc app=leetcode.cn id=1744 lang=java
 *
 * [1744] 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 */

// @lc code=start
class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        int m = queries.length;

        boolean[] res = new boolean[m];
        long[] sum = new long[n];

        sum[0] = candiesCount[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + candiesCount[i];
        }

        for (int i = 0; i < m; i++) {
            //求出每个query中在favoriteDay可能吃掉的糖果数量区间
            long candyMin = queries[i][1]+1;
            long candyMax = (long)(queries[i][1]+1)*queries[i][2];
            
            //求出每个query在favoriteType上可能存在的前缀和区间
            long left = queries[i][0] == 0 ? 1:(sum[queries[i][0]-1]+1);
            long right = sum[queries[i][0]];

            res[i] = !(candyMin > right || candyMax < left);
        }
        return res;
    }
}
// @lc code=end

