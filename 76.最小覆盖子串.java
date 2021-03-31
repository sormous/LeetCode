import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need, window;
        //申明两个map，分别来记录需要满足的字符和当前窗口中的字符
        need = new HashMap<>();
        window = new HashMap<>();
        //l,r分别表示当前窗口所在起始和结尾
        int l = 0, r = 0;
        //valid表示当前满足要求的字符数
        int valid = 0;
        int len = Integer.MAX_VALUE, start = 0;
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0)+1);
        }

        while(r < s.length()){
            //c表示当前需要添加进窗口的字符
            char c = s.charAt(r);
            r++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            //控制左侧窗口是否需要收缩
            while(valid == need.size()){
                if(r -l < len){
                    start = l;
                    len = r-l;
                }
                //d表示将要移出窗口的字符
                char d = s.charAt(l);
                l++;

                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0)-1);
                }
            }
        }
        //如果没有满足覆盖子串，则直接返回空字符串
        return len == Integer.MAX_VALUE? "" : s.substring(start, start+len);
    }
}
// @lc code=end

