/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
/**
 * 利用双指针的思想，使用两个指针分别指向位置0和n-1，
 * 因为现在数组已经是非递减顺序，所以平方之后的最大值比较头尾即可
 * 然后比较两个指针对应的数的平方，将较大的一方逆序的放进答案数组中
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        //i,j分别为两个指针，指向数组的头尾
        //pos指针指向答案数组当前位置
        for (int i = 0, j=n-1, pos = n-1; i <= j; ) {
            if(nums[i]*nums[i] > nums[j]*nums[j]){
                res[pos] = nums[i]*nums[i];
                i++;
            }else{
                res[pos] = nums[j]*nums[j];
                j--;
            }
            pos--;
        }
        return res;
    }
}
// @lc code=end

