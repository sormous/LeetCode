import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
/** 另一种好理解的思路：每次入栈2个元素，一个是入栈的元素本身，
一个是当前栈元素的最小值 * 如：入栈序列为2-3-1，
则入栈后栈中元素序列为：2-2-3-2-1-1 * 
用空间代价来换取时间代价 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

