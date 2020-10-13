import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        //初始化两个候选人candidate，和他们的计票
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;
        for (int num : nums) {
            //投票
            if(cand1 == num){
                count1++;
                continue;
            }
            if(cand2 == num){
                count2++;
                continue;
            }
            //第一个候选人配对
            if(count1 == 0){
                cand1 = num;
                count1++;
                continue;
            }
            //第二个候选人配对
            if(count2 == 0){
                cand2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }

        //计数阶段
        //找到了两个候选人，需要满足票数大于N/3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if(cand1 == num) count1++;
            else if(cand2 == num) count2++;
        }

        if(count1 > nums.length/3) res.add(cand1);
        if(count2 > nums.length/3) res.add(cand2);
        return res;
    }
}
// @lc code=end

