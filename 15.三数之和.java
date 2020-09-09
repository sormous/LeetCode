import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            //开始遍历，并且跳过重复的元素值
            if(i==0 || (i>0 && nums[i] != nums[i-1])){
                //将第一个数进行记录，sum求得差值，则变为两数之和问题
                int l = i+1, r=nums.length-1, sum = 0-nums[i];
                //利用l,r两个指针分别指向i之后数组的头尾
                while(l<r){
                    //变为两数之和问题，根据左右两指针记录的值进行判断
                    if(nums[l] + nums[r] == sum){
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        //要避免重复值出现，所以得优先判断前后是否值相同
                        while(l<r && nums[l] == nums[l+1]) l++;
                        while(l<r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }
                    else if(nums[l] + nums[r] < sum){
                        while(l<r && nums[l] == nums[l+1]) l++;
                        l++;
                    }else{
                        while(l<r && nums[r] == nums[r-1]) r--;
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

