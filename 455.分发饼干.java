import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
/**
 * 首先将两个数组进行排序，然后利用贪心算法思想，从最小需求的小孩开始满足，
 * 找到他所需的最小饼干，然后依次遍历，向后满足小孩的饼干需求
 * 最后得到可以满足的小孩总数
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        int numChild = g.length;
        int numCookies = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j=0; i < numChild&&j<numCookies; i++, j++) {
            while(j<numCookies && g[i] > s[j]){
                j++;
            }
            if(j < numCookies){
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

