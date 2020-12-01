import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
/**
 * 找出数组中大于当前栈顶元素的第一个元素，到当前元素的距离
 * 递减栈，当前元素与栈中元素比较，小则入栈，大则出栈并将二者之间的下标
 * 差值为出栈元素的结果值，并继续比较下一个栈顶元素
 * 如果栈为空，直接入栈(表示前面元素都找到了比自己大的值)
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] res = new int[T.length];
        for (int i = 0; i < res.length; i++) {
            //找出大于栈顶元素的第一个元素
            //每次找到则弹出栈中的元素，得到栈顶元素下标的值
            while(!st.isEmpty() && T[i] > T[st.peek()]){
                int temp = st.pop();
                res[temp] = i - temp;
            }
            st.push(i);
        }
        return res;
    }
}
// @lc code=end

