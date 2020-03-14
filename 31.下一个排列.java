import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len <= 1){
            return ;
        }
        for (int i=len-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                int swap = i+1;
                for(int j=i+1; j<len; j++){
                    if(nums[j] > nums[i] && nums[j] < nums[swap]){
                        swap = j;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[swap];
                nums[swap] = temp;
                Arrays.sort(nums, i+1, len);
                //交换后，你下标i后面的数组，需要进行升序排序，才能保证是数最小
                return;
            }
        }
        Arrays.sort(nums);
    }
}
// @lc code=end

