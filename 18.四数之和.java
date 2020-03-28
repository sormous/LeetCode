import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    /**
     * 特殊情况先排除，空数组和数组长度小于4的数组
     * 
     * 可以首先将数组先排序，找出其中4数和的最小值与最大值，与target比较
     * 
     * 而后遍历先取两个数，构造当前可取的最大最小值，
     * 然后向中间逼近，看是否能得到target值？
     * 
     * 
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //对目标数组进行排序，以便比较
        Arrays.sort(nums);

        //先判断特殊情况，数组长度
        if(nums.length == 0 || nums.length < 4){
            return result;
        }

        //数组可得的最小、最大值
        int min = nums[0] + nums[1] + nums[2] + nums[3];
        int max = nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3] + nums[nums.length-4];
        if(min > target || max < target){
            return result;
        }

        //遍历数组
        for(int i=0; i<nums.length-3; i++){
            //判断当前值是否与前一个值相等？
            //若相等，得到的结果列表会相同，则需要排除，跳过此次循环
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j=i+1; j<nums.length-2; j++){
                //同上
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int left = j+1;
                int right = nums.length-1;

                min = nums[i] + nums[j] + nums[left] + nums[left+1];
                max = nums[i] + nums[j] + nums[right] + nums[right - 1];
                if(min > target || max < target){
                    continue;
                }
                while(left < right){
                    //得到构造的最初值，然后与target比较，向其逼近
                    //以可变的左右指针作为循环条件
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if(temp == target){
                        List<Integer> l = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        result.add(l);

                        //同样判断当前值是否与下一个值相等，相等则跳过，避免得到重复数组
                        while(left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right] == nums[right-1]){
                            right--;
                        }
                        //同时向中间逼近，再与target进行比较
                        left++;
                        right--;
                    }
                    else if(temp<target){
                        left++;
                    }
                    else{
                        right--;
                    }
                }

            }
        }
        return result;
    }
}
// @lc code=end

