import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int ans = 0;

        // //方法1：记录i位置左右两边的最高高度
        // if (height == null) {
        //     return ans;
        // }
        

        // //首先找出第i个元素左右两边的最大元素值
        // int[] left = new int[height.length];
        // int[] right = new int[height.length];
        // for (int i = 1; i < right.length; i++) {
        //     left[i] = Math.max(left[i-1], height[i-1]);
        // }
        // for (int i = height.length-2; i >= 0; i--) {
        //     right[i] = Math.max(right[i+1], height[i+1]);
        // }

        // //然后根据木桶原理，选择左右两边矮的那一边的值做差值，进行相加
        // for (int i = 0; i < height.length-1; i++) {
        //     int temp = Math.min(left[i], right[i]);
        //     ans += Math.max(0, temp-height[i]);
        // }

        //方法2：单调栈
        //利用栈来存储单调递减的高度，遇到比当前栈顶元素高的，则弹出栈顶，进行比较
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; i++) {
            //当栈非空，则比较栈顶元素和当前遍历元素的高度，若不是单调递减，则弹出
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                //弹出元素，即表示中间最低位置
                int top = stack.pop();
                //弹出之后为空，表示其左边没有高度，那么退出循环
                if(stack.isEmpty()){
                    break;
                }
                //左边位置即为当前栈顶元素
                int left = stack.peek();
                int Width = i-left-1;
                int CurHeight = Math.min(height[i], height[left])-height[top];
                ans += Width*CurHeight;
            }
            stack.push(i);
        }

        return ans;
    }
}
// @lc code=end

