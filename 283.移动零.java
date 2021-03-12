import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // //方法1
        // //遍历数组元素
        // for (int i = 0; i < nums.length; i++) {
        //     //遇到元素值为0，则将其与后续的第一个不为0的元素进行交换
        //     if(nums[i] == 0){
        //         for (int j = i+1; j < nums.length; j++) {
        //             if(nums[j] != 0){
        //                 nums[i] = nums[j];
        //                 nums[j] = 0;
        //                 break;
        //             }
        //         }
        //     }
        // }

        //方法2,双指针
        //i指向当前遍历到的位置，j指向当前非0元素的位置
        int i, j=0;
        for(i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        while(j<nums.length){
            nums[j++] = 0;
        }
    }
}
// @lc code=end

