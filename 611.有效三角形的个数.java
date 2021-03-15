/*
 * @lc app=leetcode.cn id=611 lang=java
 *
 * [611] 有效三角形的个数
 */

// @lc code=start
class Solution {
    public int triangleNumber(int[] nums) {
        int res = 0;
        if(nums.length < 3) return res;
        //利用三层循环遍历，然后判断是否任意两边之和大于第三条边
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {         
                    if((nums[i] + nums[j] > nums[k])
                        &&(nums[i]+nums[k] > nums[j]) 
                        &&(nums[j]+nums[k] > nums[i])) res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

