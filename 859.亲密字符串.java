import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String a, String b) {
        //首先判断长度是否相等，若不相等直接判false
        if(a.length() != b.length()) return false;
        int n = a.length();
        //然后申明两个字符变量，来记录遍历过程中不同的字符
        char c1=' ', c2=' ';
        //记录当前遇到的不同字符数量
        int count = 0;
        for (int i = 0; i < n; i++) {
            //若相等则跳过本次循环
            if(a.charAt(i) == b.charAt(i)) continue;
            //不相等，则根据记录的不同字符数量来分别判断
            if(a.charAt(i) != b.charAt(i)){
                //若为首次不同，则记录下来
                if(count == 0){
                    c1 = a.charAt(i);
                    c2 = b.charAt(i);
                    count++;
                }else if(count == 1){   //第二次不同，则判断是否与前面记录的是否相等
                    if(c1 != b.charAt(i) || c2 != a.charAt(i)){
                        return false;
                    }
                    count++;
                }else{  //若再有不相同的，则直接返回false
                    return false;
                }
                
            }
        }
        //若不同的字符仅为1对
        if(count == 1) return false;
        //若两字符串完全相同，则判断字符串中是否有相同的字符
        if(count == 0) return hasSame(a);
        return true;
    }

    private boolean hasSame(String s){
        boolean flag = false;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                flag = true;
                break;
            }
            set.add(s.charAt(i));
        }
        return flag;
    }
}
// @lc code=end

