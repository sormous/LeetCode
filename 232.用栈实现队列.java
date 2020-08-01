import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {
    //利用两个栈实现队列操作
    private Stack<Integer> a;
    private Stack<Integer> b;
    /** Initialize your data structure here. */
    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        a.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //当栈b为空时，将a栈中所有元素移至b栈
        if(b.isEmpty()){
            while(!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(b.isEmpty()){
            while(!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        //当两个栈都为空时，该队列即为空
        return a.isEmpty() && b.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

