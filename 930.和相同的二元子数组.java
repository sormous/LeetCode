import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=930 lang=java
 *
 * [930] 和相同的二元子数组
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            if(sum == goal){
                res++;
            }
            if(sum > goal){
                continue;
            }
            for (int j = i+1; j < n; j++) {
                sum += nums[j];
                if(sum == goal){
                    res++;
                }
                if(sum > goal){
                    break;
                }
            }
        }
        return res;
    }
}
// @lc code=end

