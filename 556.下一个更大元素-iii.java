import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=556 lang=java
 *
 * [556] 下一个更大元素 III
 */

// @lc code=start
class Solution {
    char[] nums;
    public int nextGreaterElement(int n) {
        boolean flag = false;
        nums = (""+n).toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        int location = 0;
        //倒序遍历，找到第一对nums[i]<nums[i+1]，进行交换，变成更大的数字
        for (int i = nums.length-1; i >= 0; i--) {
            if(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                int temp = -1;
                //然后找到栈中刚好大于nums[i]的最小元素，来进行交换
                while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                    temp = stack.pop();
                }
                swap(temp, i);
                location = i+1;
                flag = true;
                break;  
            }
            stack.push(i);
        }
        //交换之后，后续的数字应该变成升序排列，保证最小
        Arrays.sort(nums, location, nums.length);
        
        //对char[]数组不能使用toString()方法，得到的是一个地址字符串，应该使用String.valueOf
        long temp = Long.parseLong(String.valueOf(nums));
        if(flag && temp <= Integer.MAX_VALUE) return (int) temp;
        else return -1;

    }
    private void swap(int i, int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

