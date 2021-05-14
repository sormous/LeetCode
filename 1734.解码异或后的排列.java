/*
 * @lc app=leetcode.cn id=1734 lang=java
 *
 * [1734] 解码异或后的排列
 */

// @lc code=start
class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int perm[] = new int[n];
        int all = 0;
        for (int i = 1; i <= n; i++) {
            all ^= i;
        }

        int odd = 0;
        for (int i = 1; i < n-1; i+=2) {
            odd ^= encoded[i];
        }

        perm[0] = all^odd;
        for (int i = 0; i < n-1; i++) {
            perm[i+1] = perm[i]^encoded[i];
        }

        return perm;
    }
}
// @lc code=end

