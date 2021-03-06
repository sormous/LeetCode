/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
/**
 * 利用三个指针i,j,cur分别表示0的最右边界，2的最左边界和当前元素位置
 */
class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length-1, cur = 0;
        //当前元素位置小于等于2的最左边界
        while(cur <= j){
            //若当前位置元素为0，则将当前元素与元素nums[i]交换
            //0的边界右移，cur也右移
            //为什么i和cur同时右移，因为cur与i交换得到的元素值必是0或1
            //所以同时变化
            if(nums[cur] == 0){
                swap(nums, i, cur);
                i++;
                cur++;
            }
            //若当前位置元素为2，则将当前元素与nums[j]交换
            //2的边界左移
            //为什么只变化j，因为cur与j交换得到的元素值可能是0,1,2
            //所以只变化j，cur的元素值还需进一步进行判断
            else if(nums[cur] == 2){
                swap(nums, j, cur);
                j--;
            }
            //若为1，则只是cur右移
            else cur++;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
}
// @lc code=end

