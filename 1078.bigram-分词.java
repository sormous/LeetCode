import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1078 lang=java
 *
 * [1078] Bigram 分词
 */

// @lc code=start
class Solution {
    /**
     * 利用栈的思想，当遇到first则入栈，遇到second，那么判断栈顶是否为first，是则入栈
     * 若栈顶是second，那么当前单词为third
     * @param text
     * @param first
     * @param second
     * @return
     */
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new LinkedList<>();

        for (String word : words) {
            
            if(!stack.isEmpty() && stack.peek().equals(second)){
                sb.append(word+" ");
            }

            if(word.equals(first)){
                stack.push(word);
            }else if(!stack.isEmpty() && first.equals(stack.peek()) && word.equals(second)){
                stack.push(word);
            }else{
                //若既不是first又不是second，则清空stack
                stack.clear();
            }

            
        }
        String ans = sb.toString();
        return ans.length() == 0 ? new String[0] : ans.split(" ");

    }
}
// @lc code=end

