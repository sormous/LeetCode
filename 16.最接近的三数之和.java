import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //首先对数组进行排序
        Arrays.sort(nums);
        //取前三个数之和作为比较基础
        int closestNum = nums[0] + nums[1] + nums[2];
        //开始遍历至数组最后三个
        for (int i = 0; i < nums.length-2; i++) {
            //设置两个指针分别指向i之后数组的首尾
            int l = i+1, r=nums.length-1;
            while(l<r){
                //声明sum来记录当前三个元素之和
                int sum = nums[i] + nums[l] + nums[r];
                //比较当前和值和初始比较值对target做差值的绝对值
                if(Math.abs(sum-target) < Math.abs(closestNum-target)){
                    closestNum = sum;
                }
                if(sum > target){
                    r--;
                }else if(sum < target){
                    l++;
                //若直接等于target那么直接返回target即可
                }else{
                    return target;
                }
            }
        }
        return closestNum;
    }
}
// @lc code=end

