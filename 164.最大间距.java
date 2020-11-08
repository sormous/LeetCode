import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start

class Solution {
    public class buket{
        boolean used = false;
        int maxval = Integer.MAX_VALUE;
        int minval = Integer.MIN_VALUE;
    }

    public int maximumGap(int[] nums) {
        //若数组的长度小于2，则直接不用比较，返回0即可
        if(nums.length < 2) return 0;
        //否则，对数组进行排序
        Arrays.sort(nums);
        int MaxDiff = Integer.MIN_VALUE;
        //对排序后的数组进行遍历
        for (int i = 0; i < nums.length-1; i++) {
            int diff = nums[i+1] - nums[i];
            MaxDiff = diff > MaxDiff ? diff : MaxDiff;
        }
        return MaxDiff;
    }
}
// @lc code=end

