/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
/**
 * 因为在插入一个单一元素的数值后，后续的数组元素规律则会变化
 * 利用这个规律，就可以判断，在单一元素之前都是偶数位和它之后一位的数值应该相等；
 * 在其之后的元素，则是因为添加了这个单一元素，则不会相等
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0, r=nums.length-1;
        while(l<r){
            int m = l+(r-l)/2;
            if(m%2 == 1) m--;
            if(nums[m] == nums[m+1]){
                //每次比较之后，下一次比较的左边界则变为+2
                l = m+2;
            }else{
                r = m;
            }
        }
        return nums[l];
    }
}
// @lc code=end

