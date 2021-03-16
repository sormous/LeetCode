import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
/**
 * 因为如果某个x, 0<x<=n，那么他所对应的下标就在x-1
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //遍历循环，交换数值，因为交换之后的nums[i]仍可能0<nums[i]<=n
        //所以需要继续判断
        //并且需要额外判断是否与交换位置上的数值已经相等，避免死循环
        for (int i = 0; i < nums.length; i++) {
            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]){
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[nums[i]-1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
        
        // //利用排序的算法进行查询
        // int res = 0;
        // Arrays.sort(nums);
        // boolean flag = true;
        // int temp = 0;
        // for (int num : nums) {
        //     if(num <= 0) continue;
        //     if(num == temp) continue;
        //     if(num != ++res){
        //         flag = false;
        //         break;
        //     }
        //     temp = num;
        // }
        // if(flag) return ++res;
        // else return res;

    }
}
// @lc code=end

