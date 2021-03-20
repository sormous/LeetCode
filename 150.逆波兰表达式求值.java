import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        //对边字符串数组进行遍历
        for (String s : tokens) {
            //当遇到符号时，则弹出两个元素，进行相应的计算，否则，添加进栈
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String s3 = "";
                if(s.equals("+")){
                    s3 = Integer.toString(Integer.valueOf(s1)+Integer.valueOf(s2));
                }
                else if(s.equals("-")){
                    s3 = Integer.toString(Integer.valueOf(s2) - Integer.valueOf(s1));
                }else if(s.equals("*")){
                    s3 = Integer.toString(Integer.valueOf(s1) * Integer.valueOf(s2));
                }else{
                    s3 = Integer.toString(Integer.valueOf(s2)/Integer.valueOf(s1));
                }
                stack.push(s3);
            }else{
                stack.push(s);
            }
        }
        
        return Integer.valueOf(stack.pop());
    }
}
// @lc code=end

