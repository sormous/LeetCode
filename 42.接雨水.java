import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int ans = 0;

        //首先找出第i个元素左右两边的最大元素值
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 1; i < right.length; i++) {
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        for (int i = height.length-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i+1]);
        }

        //然后根据木桶原理，选择左右两边矮的那一边的值做差值，进行相加
        for (int i = 0; i < height.length-1; i++) {
            int temp = Math.min(left[i], right[i]);
            ans += Math.max(0, temp-height[i]);
        }

        return ans;
    }
}
// @lc code=end

