/*
 * @lc app=leetcode.cn id=1310 lang=java
 *
 * [1310] 子数组异或查询
 */

// @lc code=start
class Solution {
    /**
     * 利用前缀数组保存前序的异或运算
     * xors[i] = arr[0] ^ ... ^arr[i-1]
     * q(l, r) = xors[l] ^ xors[r+1]
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xors = new int[n+1];
        xors[0] = 0;
        for (int i = 0; i < n; i++) {
            xors[i+1] = xors[i]^arr[i]; 
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = xors[queries[i][0]]^xors[queries[i][1]+1];
        }
        return res;

        // int n = queries.length;
        // int[] res = new int[n];
        // for (int i = 0; i < n; i++) {
        //     res[i] = calcu(queries[i][0], queries[i][1], arr);
        // }
        // return res;
    }

    public int calcu(int l, int r, int[] arr){
        int res = 0;
        for (int i = l; i <= r; i++) {
            res ^= arr[i];
        }
        return res;
    }
}
// @lc code=end

