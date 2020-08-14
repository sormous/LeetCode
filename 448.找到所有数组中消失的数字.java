import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        //将数组排序进行遍历判断
        Arrays.sort(nums);
        //标签数据，因为数组元素为1~n，所以从1开始
        int tag = 1;
        for (int i = 0; i < nums.length; i++) {
            //当标签数据小于当前数据，直接将其添加至列表中。并自增
            while(nums[i] > tag){
                ans.add(tag);
                tag++;
            }
            //相等时，则tag自增即可
            if(nums[i] == tag){
                tag++;
            }
        }
        //最后tag标签数据之后至n的数据添加至列表
        for(;tag<=nums.length; tag++){
            ans.add(tag);
        }
        return ans;
    }
}
// @lc code=end

