import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();

        String[] p = path.split("/");
        StringBuffer sb = new StringBuffer();

        for (String s : p) {
            if(s.equals("")){
                continue;
            }
            else if(s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(s);
            }
        }
        if(stack.isEmpty()){
            sb.append("/");
        }
        else{
            while(!stack.isEmpty()){
                sb.append("/" + stack.pollLast());
            }
        }
        return sb.toString();
    }
}
// @lc code=end

