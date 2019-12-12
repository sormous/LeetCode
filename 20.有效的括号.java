import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    /**
     * 括号必须配对，并且需要以正确的顺序
     * 
     * 栈的使用
     * 使用一个栈来对输入的括号串进行处理
     * 左括号则入栈，右括号则与栈顶括号比较是否能配对
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        //分别将左括号，右括号存储在字符串中，方便后续比较
        final String left = "([{";
        final String right = ")]}";

        for (int index=0; index<s.length(); index++){
            char c = s.charAt(index);
            //如果是左括号则入栈
            if(left.indexOf(c) > -1){
                stack.push(c);
            }else{//右括号则进行比较
                if(stack.isEmpty() || right.indexOf(c) != left.indexOf(stack.peek())){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

