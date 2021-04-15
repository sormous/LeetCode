import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    Deque<Integer> stack = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        //循环两次单调栈的判断和添加，即可解决循环数组中找下一个更大元素问题
        //这里应该记录下标位置来表示元素，否则在循环判断时会导致相同值的元素
        for (int i = 0; i < 2; i++) {
            for (int j=0; j<n; j++) {
                while(!stack.isEmpty() && nums[stack.peek()] < nums[j]){
                    int temp = stack.pop();
                    map.put(temp, j);
                }
                stack.push(j);
            }
        }

        for (int i = 0; i < n; i++) {
            res[i] = map.getOrDefault(i, -1) == -1?-1:nums[map.get(i)];
        }

        return res;
    }
}
// @lc code=end

